package com.jpm.myjmsapp.receiver;

import com.jpm.myjmsapp.processor.SalesEngine;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ReceiverTest {

    @Mock
    SalesEngine salesEngine;

    @InjectMocks
    Receiver sut;

    @Before
    public void setUp(){
        //Mockito.when(salesEngine.process()).thenReturn();
    }

    @Test
    public void testMessageType1(){
        sut.receiveMessage("apple at 10p");
    }
}