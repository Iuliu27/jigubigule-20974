package com.example.meepmeeptesting;

import com.noahbres.meepmeep.MeepMeep;

public class MeepMeepTesting {
    public static void main(String[] args){
        MeepMeepStorage robot = new MeepMeepStorage();

        robot.meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(robot.AutoRedStanga3Up)
                .start();
    }
}