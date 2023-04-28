package pt.ipp.isep.dei.esoft.project.domain;

public class Photo extends Property {

    private String namePhoto;
    private String extention;

    private static final String PHOTO_NAME_POR_OMISSAO = "without photo name";
    private static final String EXTENCION_POR_OMISSAO = "without extention";

    public Photo() {
        super();
        namePhoto = PHOTO_NAME_POR_OMISSAO;
        extention = EXTENCION_POR_OMISSAO;
    }

    public Photo(String designation, float area, float distanceCityCenter, float price, String typeOfProperty, String date, String namePhoto, String extention) {
        super(designation, area, distanceCityCenter, price, typeOfProperty, date);
        this.namePhoto = namePhoto;
        this.extention = extention;
    }

    public String getNamePhoto() {
        return namePhoto;
    }

    public void setNamePhoto(String namePhoto) {
        this.namePhoto = namePhoto;
    }

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }

    @Override
    public String toString() {
        return (super.toString() +
                "\nPhoto:\n" +
                "namePhoto - " + namePhoto + ";\n" +
                "extention - " + extention + ";\n");
    }


}
