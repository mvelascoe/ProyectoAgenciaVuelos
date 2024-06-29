package com.proyectojava;

import java.text.ParseException;
import java.util.Scanner;

import com.proyectojava.generalConsole.in.GeneralConsoleAdapter;

public class Main {
    public static void main(String[] args) throws ParseException {

        GeneralConsoleAdapter adapter = new GeneralConsoleAdapter();
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }

        System.out.println(
                "  ###    #######  ######    #####             #####   ####      #####   ######     ###    ####     ");
        System.out.println(
                " ## ##    ##   #   ##  ##  ### ###           ##   ##   ##      ### ###   ##  ##   ## ##    ##      ");
        System.out.println(
                "##   ##   ##       ##  ##  ##   ##           ##        ##      ##   ##   ##  ##  ##   ##   ##      ");
        System.out.println(
                "##   ##   ####     #####   ##   ##           ## ####   ##      ##   ##   #####   ##   ##   ##      ");
        System.out.println(
                "#######   ##       ## ##   ##   ##           ##   ##   ##      ##   ##   ##  ##  #######   ##      ");
        System.out.println(
                "##   ##   ##   #   ## ##   ### ###           ##   ##   ##  ##  ### ###   ##  ##  ##   ##   ##  ##  ");
        System.out.println(
                "##   ##  #######  #### ##   #####             #####   #######   #####   ######   ##   ##  #######  ");

        adapter.showMainMenu();

    }

}