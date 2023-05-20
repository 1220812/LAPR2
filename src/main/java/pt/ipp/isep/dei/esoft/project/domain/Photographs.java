package pt.ipp.isep.dei.esoft.project.domain;

public class Photographs {

    private int photoID;

    private String photoURI;

    private final int PHOTO_ID_BY_DEFAULT = 0;

    private int count=PHOTO_ID_BY_DEFAULT;
    private final String PATH_TO_PNG_BY_DEFAULT = "[NO DATA]";

    /**
     * This method creates the Photo object with default attributes
     */
    public Photographs(){
        count++;
        this.photoID = count;
        this.photoURI = PATH_TO_PNG_BY_DEFAULT;
    }

    /**
     * Creates a new photograph with ID and URI
     * @param photoURI
     */
    public Photographs(String photoURI){
        count++;
        this.photoID = count;
        this.photoURI = photoURI;
    }

    /**
     *  Returns the photoID of the Photo
     *
     * @return photoID
     */
    public int getPhotoID() {
        return photoID;
    }

    /**
     *  This method changes the photoID of the Photo
     * @param photoID
     */
    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    /**
     *  This method returns the photoURL of the Photo
     *
     * @return
     */
    public String getPhotoURI() {
        return photoURI;

    }

    /**
     *  This method changes the photoURI of the Photo
     * @param photoURI
     */
    public void setPhotoURI(String photoURI) {
        this.photoURI = photoURI;
    }

    // TOSTRING

    /**
     * This method returns the characteristics of the Photo
     *
     * @return
     */
    @Override
    public String toString() {
        return " | PhotoID: "+photoID+" | Path To PNG: "+ photoURI;
    }
}