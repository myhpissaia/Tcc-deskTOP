/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Ong;
import java.util.ArrayList;

/**
 *
 * @author <Leticia e Mylena>
 */
public class BD {
     private static  ArrayList<Ong>ong=new ArrayList<Ong>();

    /**
     * @return the ong
     */
    public static ArrayList<Ong> getOng() {
        return ong;
    }

    /**
     * @param aOng the ong to set
     */
    public static void setOng(ArrayList<Ong> aOng) {
        ong = aOng;
    }
}
