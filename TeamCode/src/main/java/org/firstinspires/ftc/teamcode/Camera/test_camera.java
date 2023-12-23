package org.firstinspires.ftc.teamcode.Camera;

import  com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.openftc.easyopencv.OpenCvCamera;

@Autonomous(name = "Zone_Detector",group="Iuliu")
public class test_camera extends LinearOpMode {
    String ConeZone;
    cameraHW camera = new cameraHW();
    OpenCvCamera externalCamera;
    cameraHW.ZoneDetector pipeline;

    @Override
    public void runOpMode() throws InterruptedException {
        camera.initExternalCamera();
        waitForStart();

        while (opModeIsActive()) {
            ConeZone = camera.isPointInsideRect();
            if (ConeZone.equals("LEFT")) {
                // Code for LEFT position
            } else if (ConeZone.equals("MIDDLE")) {
                // Code for MIDDLE position
            } else if (ConeZone.equals("RIGHT")) {
                // Code for RIGHT position
            }


        }
    }
}