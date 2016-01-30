package com.catalog.app.graphic;

import junit.framework.TestCase;

import org.junit.Test;

public class ScaleImageEnumTest extends TestCase {

    @Test
    public void testGetScaleNumber() throws Exception {
        assertEquals("Wrong image scale size",1,ScaleImageEnum.getScaleNumber(ScaleImageEnum.ONE));
        assertEquals("Wrong image scale size",2,ScaleImageEnum.getScaleNumber(ScaleImageEnum.TWO));
        assertEquals("Wrong image scale size",3,ScaleImageEnum.getScaleNumber(ScaleImageEnum.THREE));
        assertEquals("Wrong image scale size",4,ScaleImageEnum.getScaleNumber(ScaleImageEnum.FOUR));
        assertEquals("Wrong image scale size",5,ScaleImageEnum.getScaleNumber(ScaleImageEnum.FIVE));
        assertEquals("Wrong image scale size",6,ScaleImageEnum.getScaleNumber(ScaleImageEnum.SIX));
        assertEquals("Wrong image scale size",7,ScaleImageEnum.getScaleNumber(ScaleImageEnum.SEVEN));
    }
}