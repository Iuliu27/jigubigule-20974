package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.HardwareMap.HardwareMapp;
import org.firstinspires.ftc.teamcode.tuning.mapping.MecanumDrive;
import org.firstinspires.ftc.teamcode.tuning.TuningOpModes;

import java.util.ArrayList;
import java.util.List;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp")
public class TeleOP extends LinearOpMode {
    HardwareMapp Robot=new HardwareMapp();
    private List<Action> runningActions = new ArrayList<>();

    //HardwareMapping hw=new HardwareMapping();
    private MecanumDrive drive;
    @Override
    public void runOpMode() throws InterruptedException {

        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        double TriggerSlowdown=gamepad2.right_trigger,heading=180;

        waitForStart();

        while(opModeIsActive()){

            if(isStopRequested())return;
            TelemetryPacket packet = new TelemetryPacket();

            if(TuningOpModes.DRIVE_CLASS.equals(MecanumDrive.class)) {
                drive.setDrivePowers(new PoseVelocity2d(   //miscarea de baza a robotului
                        new Vector2d(
                                -gamepad2.left_stick_y,
                                -gamepad2.left_stick_x
                        ),
                        -gamepad2.right_stick_x
                ));
            }

            //gamepad1

            if(gamepad1.x){

            }
            if(gamepad2.x) {

            }

            List<Action> newActions = new ArrayList<>();
            for (Action action : runningActions) {
                action.preview(packet.fieldOverlay());
                if (action.run(packet)) {
                    newActions.add(action);
                }
            }
            runningActions = newActions;
        }
    }
}