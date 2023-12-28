package org.firstinspires.ftc.teamcode.Autonomii;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.HardwareMap.HardwareMapp;
import org.firstinspires.ftc.teamcode.tuning.mapping.MecanumDrive;

public class AutoRedStanga3Down extends LinearOpMode {
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

        cPose=firstPose;

        Action TrajRightLane = drive.actionBuilder(cPose)  //Traiectorie pana la linea din dreapta
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(-29, -33, Math.toRadians(60)), Math.toRadians(60))
                .build();

        cPose=RightLane;

        Action TrajLeftStack = drive.actionBuilder(cPose)  //Traiectorie pana la stackul din stanga
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(-53, -36, Math.toRadians(0)), Math.toRadians(90))
                .afterDisp(1, new SequentialAction(
                        new ParallelAction(
                                Robot.Intake("lessThan2Pixels"),
                                Robot.maturiceLevel("Level6")
                        )
                ))
                .build();

        cPose=LeftStack;

        Action TrajBackboardRight = drive.actionBuilder(cPose)
                .setTangent(Math.toRadians(90))
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(0))
                .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(0))
                .splineToLinearHeading(new Pose2d(48,-42,Math.toRadians(0)),Math.toRadians(0))
                .build();

        cPose=BackboardRight;

        Action TrajToLeftStackLevel6 = drive.actionBuilder(cPose)  //Traiectorie pana la stackul din stanga
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-53,-36,Math.toRadians(0)),Math.toRadians(180))
                .afterDisp(1, new SequentialAction(
                        new ParallelAction(
                                Robot.Intake("lessThan2Pixels"),
                                Robot.maturiceLevel("Level6")
                        )
                ))
                .build();

        cPose=BackboardRight;

        Action TrajToLeftStackLevel5 = drive.actionBuilder(cPose)  //Traiectorie pana la stackul din stanga
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-53,-36,Math.toRadians(0)),Math.toRadians(180))
                .afterDisp(1, new SequentialAction(
                        new ParallelAction(
                                Robot.Intake("lessThan2Pixels"),
                                Robot.maturiceLevel("Level5")
                        )
                ))
                .build();

        cPose=BackboardRight;

        Action TrajToLeftStackLevel4 = drive.actionBuilder(cPose)  //Traiectorie pana la stackul din stanga
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-53,-36,Math.toRadians(0)),Math.toRadians(180))
                .afterDisp(1, new SequentialAction(
                        new ParallelAction(
                                Robot.Intake("lessThan2Pixels"),
                                Robot.maturiceLevel("Level4")
                        )
                ))
                .build();

        cPose=BackboardRight;

        Action TrajToLeftStackLevel3 = drive.actionBuilder(cPose)  //Traiectorie pana la stackul din stanga
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-53,-36,Math.toRadians(0)),Math.toRadians(180))
                .afterDisp(1, new SequentialAction(
                        new ParallelAction(
                                Robot.Intake("lessThan2Pixels"),
                                Robot.maturiceLevel("Level3")
                        )
                ))
                .build();

        cPose=BackboardRight;

        Action TrajToLeftStackLevel2 = drive.actionBuilder(cPose)  //Traiectorie pana la stackul din stanga
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-53,-36,Math.toRadians(0)),Math.toRadians(180))
                .afterDisp(1, new SequentialAction(
                        new ParallelAction(
                                Robot.Intake("lessThan2Pixels"),
                                Robot.maturiceLevel("Level2")
                        )
                ))
                .build();

        cPose=BackboardRight;

        Action TrajToLeftStackLevel1 = drive.actionBuilder(cPose)  //Traiectorie pana la stackul din stanga
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-53,-36,Math.toRadians(0)),Math.toRadians(180))
                .afterDisp(1, new SequentialAction(
                        new ParallelAction(
                                Robot.Intake("lessThan2Pixels"),
                                Robot.maturiceLevel("Level1")
                        )
                ))
                .build();

        cPose=BackboardRight;

        Action ParkingRight = drive.actionBuilder(cPose)
                .setReversed(true)
                .setTangent(Math.toRadians(-90))
                .splineToSplineHeading(new Pose2d(48,-56,Math.toRadians(0)),Math.toRadians(270))
                .build();

        waitForStart();

        Actions.runBlocking(new SequentialAction(
                TrajRightLane,
                TrajLeftStack,
                TrajBackboardRight,
                TrajToLeftStackLevel4,
                TrajBackboardRight,
                TrajToLeftStackLevel2,
                TrajBackboardRight,
                ParkingRight
        ));

        while(opModeIsActive() && !isStopRequested()){
            telemetry.addData("x :",drive.pose.position.x);
            telemetry.addData("y :",drive.pose.position.y);
            telemetry.addData("Current Pose :",cPose);
        }
    }
}