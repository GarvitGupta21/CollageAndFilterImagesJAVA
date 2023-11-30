/*************************************************************************
 *  Compilation:  javac ArtCollage.java
 *  Execution:    java ArtCollage Flo2.jpeg
 *
 *  @author: 
 *
 *************************************************************************/

import java.awt.Color;

public class ArtCollage {

    // The orginal picture
    private Picture original;

    // The collage picture
    private Picture collage;

    // The collage Picture consists of collageDimension X collageDimension tiles
    private int collageDimension;

    // A tile consists of tileDimension X tileDimension pixels
    private int tileDimension;
    
    /*
     * One-argument Constructor
     * 1. set default values of collageDimension to 4 and tileDimension to 100
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename) {

        this.collageDimension= 4;
        this.tileDimension= 100;
        this.original = new Picture(filename);
        this.collage = new Picture(collageDimension*tileDimension, tileDimension*collageDimension);

        int w = tileDimension*collageDimension;
        int h = tileDimension*collageDimension;

        for (int i=0; i<w; i++){
            for (int j=0;j<h;j++){
                int scol = i*original.width()/w;
                int scrow = j* original.height()/h;
                Color color = original.get(scol,scrow);
                collage.set(i,j,color);
            }
        }

    }

    /*
     * Three-arguments Constructor
     * 1. set default values of collageDimension to cd and tileDimension to td
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename, int td, int cd) {

        this.collageDimension = cd;
        this.tileDimension = td;
        this.original= new Picture(filename);
        this.collage = new Picture(collageDimension*tileDimension, collageDimension*tileDimension);

        int w = tileDimension*collageDimension;
        int h = tileDimension*collageDimension;

        for (int i=0; i<w; i++){
            for (int j=0;j<h;j++){
                int scol = i* original.width()/w;
                int scrow = j* original.height()/h;
                Color color = original.get(scol,scrow);
                collage.set(i,j,color);
            }
        }

    }

    /*
     * Returns the collageDimension instance variable
     *
     * @return collageDimension
     */
    public int getCollageDimension() {

	    return collageDimension;
    }

    /*
     * Returns the tileDimension instance variable
     *
     * @return tileDimension
     */
    public int getTileDimension() {

	    return tileDimension;
    }

    /*
     * Returns original instance variable
     *
     * @return original
     */
    public Picture getOriginalPicture() {

	    return original;
    }

    /*
     * Returns collage instance variable
     *
     * @return collage
     */
    public Picture getCollagePicture() {

	    return collage;
    }
    
    /*
     * Display the original image
     * Assumes that original has been initialized
     */
    public void showOriginalPicture() {

	    original.show();
    }

    /*
     * Display the collage image
     * Assumes that collage has been initialized
     */
    public void showCollagePicture() {

	    collage.show();
    }

    /*
     * Replaces the tile at collageCol,collageRow with the image from filename
     * Tile (0,0) is the upper leftmost tile
     *
     * @param filename image to replace tile
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void replaceTile (String filename,  int collageCol, int collageRow) {

        Picture replacement = new Picture(filename);
        Picture replacementScaled = replacement;
        
        int w = tileDimension;
        int h = tileDimension;

        for (int i=0; i<w; i++){
            for (int j=0;j<h;j++){
                int scol = i* replacement.width()/w;
                int scrow = j* replacement.height()/h;
                Color color = replacement.get(scol,scrow);
                replacementScaled.set(i,j,color);
            }
        }
        



        for (int c=0; c<tileDimension;c++){
            for (int r=0; r<tileDimension;r++){

                int y = (c+((tileDimension)* collageCol));
                int x = (r+((tileDimension)* collageRow));

                Color color = replacementScaled.get(c,r);
                collage.set(y, x, color);

            }
        }
        
    }
    
    /*
     * Makes a collage of tiles from original Picture
     * original will have collageDimension x collageDimension tiles, each tile
     * has tileDimension X tileDimension pixels
     */
    public void makeCollage () {

        Picture original1 = original;
        Picture originalScaled = new Picture(tileDimension, tileDimension);

        int w = tileDimension;
        int h = tileDimension;

        for (int i=0; i<w; i++){
            for (int j=0;j<h;j++){
                int scol = i* original1.width()/w;
                int scrow = j* original1.height()/h;
                Color color = original1.get(scol,scrow);
                originalScaled.set(i,j,color);
            }
        }
        
        for (int i=0; i<collageDimension;i++){
            for (int j=0; j<collageDimension;j++){
                for (int r=0; r<tileDimension;r++){
                    for (int c=0; c<tileDimension;c++){

                        int y = (r+((tileDimension)*i));
                        int x = (c+((tileDimension)*j));

                        Color color = originalScaled.get(r,c);
                        collage.set(y, x, color);

                    }
                }
            }
        }
       
        
    }

    /*
     * Colorizes the tile at (collageCol, collageRow) with component 
     * (see CS111 Week 9 slides, the code for color separation is at the 
     *  book's website)
     *
     * @param component is either red, blue or green
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void colorizeTile (String component,  int collageCol, int collageRow) {

        for (int c=0; c<tileDimension;c++){
            for (int r=0; r<tileDimension;r++){

                int y = (c+((tileDimension)* collageCol));
                int x = (r+((tileDimension)* collageRow));

                Color color = collage.get(y,x);
                int red = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                if (component.equals("red")){
                    collage.set(y, x, new Color(red, 0, 0));
                }

                if (component.equals("green")){
                    collage.set(y, x, new Color(0, g, 0));
                }

                if (component.equals("blue")){
                    collage.set(y, x, new Color(0, 0, b));
                }

            }
        }
	    
    }

    /*
     * Grayscale tile at (collageCol, collageRow)
     * (see CS111 Week 9 slides, the code for luminance is at the book's website)
     *
     * @param collageCol tile column
     * @param collageRow tile row
     */

    public void grayscaleTile (int collageCol, int collageRow) {

        for (int c=0; c<tileDimension;c++){
            for (int r=0; r<tileDimension;r++){

                int y = (c+((tileDimension)* collageCol));
                int x = (r+((tileDimension)* collageRow));

                Color color = collage.get(y, x);
                Color gray = Luminance.toGray(color);
                collage.set(y, x, gray);


            }  
        }
    }
 

    /*
     *
     *  Test client: use the examples given on the assignment description to test your ArtCollage
     */
    public static void main (String[] args) {

        ArtCollage art = new ArtCollage(args[0], 50, 25); 

        art.makeCollage();  

        art.showCollagePicture();
        
    }
}
 
