package siat.courant.IO;

import siat.courant.engine.Tuple;

import java.io.IOException;
import java.util.Objects;

/**
 * Created by asus on 2015/6/19.
 */
public interface Receiver {
    void addTuple(Tuple tuple) throws IOException;
}
