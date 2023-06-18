package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.io.File;
import java.io.IOException;

/**
 * The type Import information controller.
 */
public class ImportInformationController {
    /**
     * The File importer.
     */
    FileInformation fileImporter= new FileInformation ();

    /**
     * Import file.
     *
     * @param path the path
     * @throws IOException the io exception
     */
    public void ImportFile ( String path ) throws IOException {
        //fileImporter.importFile(path);
    }

}