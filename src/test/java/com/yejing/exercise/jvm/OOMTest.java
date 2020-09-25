package com.yejing.exercise.jvm;


import com.yejing.exercise.model.ModelA;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OOMTest {
    public class Model{

    }

    @Test
    public void testa(){
        SupClass supClass  = new SupClass();
    }
}
