package fr.zenity.desbugs.utils;

import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourcesUtils {

    public static Path getResource(String path) throws URISyntaxException {
        return Paths.get(ResourcesUtils.class.getClassLoader().getResource(path).toURI());
    }

    public static InputStream getStreamResources(String path){
        return ResourcesUtils.class.getClassLoader().getResourceAsStream(path);
    }

}
