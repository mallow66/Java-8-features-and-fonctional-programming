package FunctionalProgramming.Streams;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by brahim on 6/23/17.
 */
public class StreamFromFiles {

    public static void main(String[] args){

        long uniqueWords = 0;


        try( Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())){
                uniqueWords  = lines.map(line -> line.split(" "))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .count();
        }

        catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("Unique Words count --> "+uniqueWords);
    }
}
