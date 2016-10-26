package test;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Project: SoftwareMetricsAnalyse
 * Package: main
 * Author:  Novemser
 * 2016/10/23
 */
public class Extractor {
    public static String sourceDir;
    public static String destDir = "I:\\GitUnzipped";
    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(15, 15,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());

    public static void traverseFile(File[] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
                traverseFile(file.listFiles()); // Calls same method again.
            } else {
                try {
                    if (FilenameUtils.getExtension(file.getCanonicalPath()).equals("zip"))
                    try {
                        ZipFile zipFile = new ZipFile(file);
                        Extractor.executor.execute(() -> {
                            try {
                                zipFile.extractAll(destDir);

                                System.out.println("Extract " + file.getName() + " successful.");
                            } catch (ZipException e) {
                                e.printStackTrace();
                            }
                        });
                    } catch (ZipException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String...args) {
        File[] files = new File("I:\\GithubSearchCodes\\Java\\Repositories").listFiles();
        traverseFile(files);
        executor.shutdown();
    }
}
