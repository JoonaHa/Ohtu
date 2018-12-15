/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author JoonaHa
 */
public class KonsoliIO implements IO {

    private Scanner scanner;

    public KonsoliIO(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void print(String print) {
        System.out.print(print);
    }

    @Override
    public void println(String print) {
        System.out.println(print);

    }

    @Override
    public String nextLine() {
        return this.scanner.nextLine();
    }

}
