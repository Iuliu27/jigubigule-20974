package org.firstinspires.ftc.teamcode.Autonomii;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ActionForAutonomous;
import org.firstinspires.ftc.teamcode.HardwareMap.HardwareMapp;
import org.firstinspires.ftc.teamcode.tuning.mapping.MecanumDrive;

import java.util.ArrayList;
import java.util.List;

@Autonomous(name = "AutoRedStanga3Up")
public class AutoRedStanga3Up extends LinearOpMode {

    HardwareMapp Robot = new HardwareMapp();
    HardwareMap HW = null;
    private MecanumDrive drive;
    private Pose2d cPose;
    @Override
    public void runOpMode() throws InterruptedException {

        Robot.init(hardwareMap);
        Robot.gamepadInit(gamepad1, gamepad2);

        Pose2d firstPose=new Pose2d(-37,-34,90);
        Pose2d RightLane=new Pose2d(-29,-33,60);
        Pose2d LeftStack=new Pose2d(-53,-36,0);
        Pose2d BackboardRight=new Pose2d(48,-41.31,0);
        Pose2d RightStack=new Pose2d(-56.45,-12.02,0);
        Pose2d BackboardLeft=new Pose2d(48,-29.65,0);

            cPose=firstPose;

            Action TrajRightLane = drive.actionBuilder(cPose)  //Traiectorie panan la linea din dreapta
                    .setReversed(false)
                    .splineToLinearHeading(new Pose2d(-29, -33, Math.toRadians(60)), Math.toRadians(60))
                    .build();

            cPose=RightLane;

            Action TrajLeftStack = drive.actionBuilder(cPose)
                    .setReversed(true)
                    .splineToLinearHeading(new Pose2d(-53,-36,Math.toRadians(0)),Math.toRadians(90))
                    .afterDisp(1, new SequentialAction(
                            new ParallelAction(
                                    Robot.Intake("lessThan2Pixels"),
                                    Robot.maturiceLevel("Level6")
                            )
                    ))
                    .build();

            cPose=LeftStack;

            Action TrajToBackboardRight = drive.actionBuilder(cPose)  //Traiectorie pana la backboard dreapta
                    .setTangent(Math.toRadians(90))
                    .splineToLinearHeading(new Pose2d(-38.39, -12.02, Math.toRadians(0)), Math.toRadians(0))
                    .splineToLinearHeading(new Pose2d(27, -12.02, Math.toRadians(0)), Math.toRadians(0))
                    .splineToLinearHeading(new Pose2d(48, -41.31, Math.toRadians(0)), Math.toRadians(0))
                    .afterDisp(10, new ParallelAction(
                            new SequentialAction(
                                    new ParallelAction(
                                            Robot.misum("MIDDLE")
                                    ),
                                    Robot.turnOutake("turn"),
                                    Robot.openOutake("open")
                            ),
                            Robot.openOutake("close"),
                            Robot.turnOutake("noTurn")
                    ))
                    .build();

            cPose=BackboardRight;

            //Level 1 2 3 4 5 6
            Action TrajRightStackLevel6 = drive.actionBuilder(cPose)  //Traiectorie pana la stackul din dreapta
                    .setReversed(true)
                    .splineToLinearHeading(new Pose2d(27, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    .splineToLinearHeading(new Pose2d(-56.45, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    .afterDisp(10, new SequentialAction(
                            new ParallelAction(
                                    Robot.Intake("lessThan2Pixels"),
                                    Robot.maturiceLevel("Level6")
                            )
                    ))
                    .build();

            cPose=BackboardRight;

            Action TrajRightStackLevel5 = drive.actionBuilder(cPose)  //Traiectorie pana la stackul din dreapta
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(27, -12.02, Math.toRadians(0)), Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-56.45, -12.02, Math.toRadians(0)), Math.toRadians(180))
                .afterDisp(10, new SequentialAction(
                        new ParallelAction(
                                Robot.Intake("lessThan2Pixels"),
                                Robot.maturiceLevel("Level5")
                        )
                ))
                .build();

            cPose=BackboardRight;

            Action TrajRightStackLevel4 = drive.actionBuilder(cPose)  //Traiectorie pana la stackul din dreapta
                    .setReversed(true)
                    .splineToLinearHeading(new Pose2d(27, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    .splineToLinearHeading(new Pose2d(-56.45, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    .afterDisp(10, new SequentialAction(
                            new ParallelAction(
                                    Robot.Intake("lessThan2Pixels"),
                                    Robot.maturiceLevel("Level4")
                            )
                    ))
                    .build();

            cPose=BackboardRight;

            Action TrajRightStackLevel3 = drive.actionBuilder(cPose)  //Traiectorie pana la stackul din dreapta
                    .setReversed(true)
                    .splineToLinearHeading(new Pose2d(27, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    .splineToLinearHeading(new Pose2d(-56.45, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    .afterDisp(10, new SequentialAction(
                            new ParallelAction(
                                    Robot.Intake("lessThan2Pixels"),
                                    Robot.maturiceLevel("Level3")
                            )
                    ))
                    .build();

            cPose=BackboardRight;

            Action TrajRightStackLevel2 = drive.actionBuilder(cPose)  //Traiectorie pana la stackul din dreapta
                    .setReversed(true)
                    .splineToLinearHeading(new Pose2d(27, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    .splineToLinearHeading(new Pose2d(-56.45, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    .afterDisp(10, new SequentialAction(
                            new ParallelAction(
                                    Robot.Intake("lessThan2Pixels"),
                                    Robot.maturiceLevel("Level2")
                            )
                    ))
                    .build();

            cPose=BackboardRight;

            Action TrajRightStackLevel1 = drive.actionBuilder(cPose)  //Traiectorie pana la stackul din dreapta
                    .setReversed(true)
                    .splineToLinearHeading(new Pose2d(27, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    .splineToLinearHeading(new Pose2d(-56.45, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    .afterDisp(10, new SequentialAction(
                            new ParallelAction(
                                    Robot.Intake("lessThan2Pixels"),
                                    Robot.maturiceLevel("Level1")
                            )
                    ))
                    .build();

            cPose=RightStack;

            Action TrajToBackboardLeft = drive.actionBuilder(cPose)  //Traiectorie pana la backboard stanga
                    .setReversed(false)
                    .splineToLinearHeading(new Pose2d(27, -12.02, Math.toRadians(0)), Math.toRadians(0))
                    .splineToLinearHeading(new Pose2d(48, -29.65, Math.toRadians(0)), Math.toRadians(0))
                    .afterDisp(10, new ParallelAction(
                            new SequentialAction(
                                    new ParallelAction(
                                            Robot.misum("MIDDLE")
                                    ),
                                    Robot.turnOutake("turn"),
                                    Robot.openOutake("open")
                            ),
                            Robot.openOutake("close"),
                            Robot.turnOutake("noTurn")
                    ))
                    .build();

            cPose=BackboardLeft;

            Action ParkingLeft = drive.actionBuilder(cPose)  //Traiectorie parcare stanga
                    .setReversed(true)
                    .setTangent(Math.toRadians(90))
                    .splineToSplineHeading(new Pose2d(48, -15, Math.toRadians(0)), Math.toRadians(90))
                    .afterDisp(0.1, new SequentialAction(
                            new ParallelAction(
                                    Robot.hook1("noPixel"),
                                    Robot.hook2("noPixel"),
                                    Robot.turnOutake("noTurn"),
                                    Robot.openOutake("close"),
                                    Robot.misum("GROUND")
                            )
                    ))
                    .build();

            waitForStart();
            Actions.runBlocking(new SequentialAction(
                    TrajRightLane,
                    TrajLeftStack,
                    TrajToBackboardRight,
                    TrajRightStackLevel4,
                    TrajToBackboardLeft,
                    TrajRightStackLevel2,
                    TrajToBackboardLeft,
                    ParkingLeft
            ));

            while(opModeIsActive() && !isStopRequested()){
                telemetry.addData("x :",drive.pose.position.x);
                telemetry.addData("y :",drive.pose.position.y);
                telemetry.addData("Current Pose :",cPose);
            }
    }
}