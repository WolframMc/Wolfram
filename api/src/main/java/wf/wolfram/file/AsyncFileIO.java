package wf.wolfram.file;

import akka.stream.javadsl.FileIO;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import akka.util.ByteString;

import java.nio.file.Path;

/**
 * Асинхронная работа с файлами с использованием
 * Akka Streams и Mixin API.
 */
public class AsyncFileIO {

    /**
     * Прочитать файл и сложить содержимое в Source.
     * @param path Путь
     * @return Source
     */
    public static Source lineSource(Path path, String charset)
    { return FileIO.fromPath(path).via(Flow.of(ByteString.class).map((x) -> x.decodeString(charset))).async(); }

    /**
     * Записать в файл при помощи Sink'а
     * @param path Путь
     * @return Sink
     */
    public static Sink writingSink(Path path)
    { return FileIO.toPath(path).async(); }

}
