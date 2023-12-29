package org.firstinspires.ftc.teamcode.Autonomii;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.HardwareMap.HardwareMapp;
import org.firstinspires.ftc.teamcode.tuning.mapping.MecanumDrive;

@Autonomous(name="AutoRedStanga3Down")
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

        Action TrajRightLane = drive.actionBuilder(cPose, Math.toRadians(90))  //Traiectorie pana la linea din dreapta
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(-29, -33, Math.toRadians(60)), Math.toRadians(60))
                .build();

        cPose=RightLane;

        Action TrajLeftStack = drive.actionBuilder(cPose, Math.toRadians(90))  //Traiectorie pana la stackul din stanga
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(-53, -36, Math.toRadians(0)), Math.toRadians(90))
                .afterDisp(1, new SequentialAction(
                        new ParallelAction(
                                //Robot.Intake("lessThan2Pixels"), //nsh daca trebe sa ia aici pixel (level 6)
                                Robot.maturiceLevel("Level6")
                        )
                ))
                .build();

        cPose=LeftStack;

        Action TrajBackboardRight = drive.actionBuilder(cPose, Math.toRadians(0))  //Traiectorie pana la backboard in partea dreapta
                .setTangent(Math.toRadians(90))
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(0))
                .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(0))
                .splineToLinearHeading(new Pose2d(48,-42,Math.toRadians(0)),Math.toRadians(0))
                .afterDisp(10, new ParallelAction(
                        new SequentialAction(
                                new ParallelAction(
                                        Robot.misum("MIDDLE")
                                ),
                                Robot.turnOutake("turn"),
                                Robot.openOutake("open")
                        ),
                        Robot.openOutake("close"),
                        Robot.turnOutake("noTurn"),
                        Robot.misum("GROUND")
                ))
                .build();

        cPose=BackboardRight;

        Action TrajToLeftStackLevel6 = drive.actionBuilder(cPose, Math.toRadians(180))  //Traiectorie pana la stackul din stanga
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-53,-36,Math.toRadians(0)),Math.toRadians(180))
                .afterDisp(1, new SequentialAction(
                        new ParallelAction(
                                Robot.Intake("in"),  //Level 6 nu ia niciun pixel
                                Robot.maturiceOpen_Close("in"),
                                Robot.maturiceLevel("Level6")
                        ),
                        Robot.maturiceOpen_Close("off")
                ))
                .build();

        cPose=BackboardRight;

        Action TrajToLeftStackLevel5 = drive.actionBuilder(cPose, Math.toRadians(180))  //Traiectorie pana la stackul din stanga
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-53,-36,Math.toRadians(0)),Math.toRadians(180))
                .afterDisp(1, new SequentialAction(
                        new ParallelAction(
                                Robot.Intake("in"),
                                Robot.maturiceOpen_Close("in"),
                                Robot.maturiceLevel("Level5")
                        ),
                        Robot.maturiceOpen_Close("off")
                ))
                .build();

        cPose=BackboardRight;

        Action TrajToLeftStackLevel4 = drive.actionBuilder(cPose, Math.toRadians(180))  //Traiectorie pana la stackul din stanga
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-53,-36,Math.toRadians(0)),Math.toRadians(180))
                .afterDisp(1, new SequentialAction(
                        new ParallelAction(
                                Robot.Intake("in"),
                                Robot.maturiceOpen_Close("in"),
                                Robot.maturiceLevel("Level4")
                        ),
                        Robot.maturiceOpen_Close("off")
                ))
                .build();

        cPose=BackboardRight;

        Action TrajToLeftStackLevel3 = drive.actionBuilder(cPose, Math.toRadians(180))  //Traiectorie pana la stackul din stanga
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-53,-36,Math.toRadians(0)),Math.toRadians(180))
                .afterDisp(1, new SequentialAction(
                        new ParallelAction(
                                Robot.Intake("in"),
                                Robot.maturiceOpen_Close("in"),
                                Robot.maturiceLevel("Level3")
                        ),
                        Robot.maturiceOpen_Close("off")
                ))
                .build();

        cPose=BackboardRight;

        Action TrajToLeftStackLevel2 = drive.actionBuilder(cPose, Math.toRadians(180))  //Traiectorie pana la stackul din stanga
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-53,-36,Math.toRadians(0)),Math.toRadians(180))
                .afterDisp(1, new SequentialAction(
                        new ParallelAction(
                                Robot.Intake("in"),
                                Robot.maturiceOpen_Close("in"),
                                Robot.maturiceLevel("Level2")
                        ),
                        Robot.maturiceOpen_Close("off")
                ))
                .build();

        cPose=BackboardRight;

        Action TrajToLeftStackLevel1 = drive.actionBuilder(cPose, Math.toRadians(180))  //Traiectorie pana la stackul din stanga
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-53,-36,Math.toRadians(0)),Math.toRadians(180))
                .afterDisp(1, new SequentialAction(
                        new ParallelAction(
                                Robot.Intake("in"),
                                Robot.maturiceOpen_Close("in"),
                                Robot.maturiceLevel("Level1")
                        ),
                        Robot.maturiceOpen_Close("off")
                ))
                .build();

        cPose=BackboardRight;

        Action ParkingRight = drive.actionBuilder(cPose, Math.toRadians(270))
                .setReversed(true)
                .setTangent(Math.toRadians(-90))
                .splineToSplineHeading(new Pose2d(48,-56,Math.toRadians(0)),Math.toRadians(270))
                .afterDisp(0.1, new SequentialAction(
                        new ParallelAction(
                                Robot.hook1("noPixel"),
                                Robot.hook2("noPixel"),
                                Robot.turnOutake("noTurn"),
                                Robot.openOutake("close"),
                                Robot.Intake("off"),
                                Robot.maturiceOpen_Close("off"),
                                Robot.misum("GROUND")
                        )
                ))
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