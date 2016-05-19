package com.spaceapps.mod;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import scala.util.parsing.json.JSON;
public class ImageServer {
    //Variables estaticas
    private float mapWidthInDegree = 360.0f;
    private float mapHeightInDegree = 180.0f;
    private float mapStartLon = -180.0f;
    private float mapStartLat = 90.0f;
    
    //Las imagenes siempre son de 256x256
    private int pixelTileWidth = 256;
    private int pixelTileHeight = 256;
    
    private int maximumZoom = 5;
    private int elevationOffset = -8201;
    private float elevationScale = 115.4588f;
    
    
    private float min = 100000000;
    private float max = 0;
    
    public int[][] getHeightMap(int offsetX, int offsetY) throws Exception{
    	int x=4,y=4;
        int result[][] = null;
        offsetX = (offsetX)*4;
        offsetY = (offsetY)*4;
        
        int superM[][][][] = new int[x][y][pixelTileHeight][pixelTileWidth];
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                superM[i][j] = getMatrixMap(offsetX + i, offsetY + j);
            }
        }
        
        result = merge(superM);
        
        
        return result;
    }
    
    private int[][] getMatrixMap(int row, int col) throws Exception{
        BufferedImage image = null;
        URL url = new URL("https://api.nasa.gov/mars-wmts/catalog/Mars_MGS_MOLA_DEM_mosaic_global_463m_8/1.0.0/default/default028mm/" + maximumZoom + "/" + row + "/" + col + ".png");
        System.out.println("URL: " + url.toString());
        URLConnection connection = url.openConnection();
        //connection.setRequestProperty("User-Agent", "xxxxxx");
        
        image = ImageIO.read(connection.getInputStream());

        int[][] result = new int[pixelTileHeight][pixelTileWidth];
        int temp = 0;
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color c = new Color(image.getRGB(x, y), true);
                temp = (int)(c.getRed() * elevationScale + elevationOffset);
                result[y][x] = temp;
                if(temp<min)min = temp;
                if(temp>max)max=temp;
            }
        }
        //System.out.println("Max: " + max);
        //System.out.println("Min: " + min);
        return result;
    }
    
    private int[][] merge(int[][][][] superMatrix){
        int[][] result = new int[superMatrix.length * superMatrix[0][0].length][superMatrix[0].length * superMatrix[0][0][0].length];
        
        for (int i = 0; i < superMatrix.length; i++) {
            for (int j = 0; j < superMatrix[0].length; j++) {
                for (int k = 0; k < superMatrix[0][0].length; k++) {
                    for (int l = 0; l < superMatrix[0][0][0].length; l++) {
                        result[i*pixelTileWidth + k][j*pixelTileHeight + l] = superMatrix[i][j][k][l];
                    }
                }
            }
        }
        
        //Normalizando valores
        max = max-min;
        for(int i=0; i<result.length; i++){
            for(int j=0; j<result[0].length; j++){
                result[i][j] = (int)(((result[i][j] - min)/max)*100);
            }
        }
        
        return result;
    }
    
}
