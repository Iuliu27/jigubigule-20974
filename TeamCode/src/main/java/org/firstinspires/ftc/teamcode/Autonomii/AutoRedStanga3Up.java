package org.firstinspires.ftc.teamcode.Autonomii;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SafePathBuilder;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.HardwareMap.HardwareMapp;
import org.firstinspires.ftc.teamcode.tuning.mapping.MecanumDrive;

@Autonomous(name = "AutoRedStanga3Up")
public class AutoRedStanga3Up extends LinearOpMode {

    HardwareMapp Robot = new HardwareMapp();
    private MecanumDrive drive;
    private Pose2d cPose;
    @Override
    public void runOpMode() throws InterruptedException {

        Robot.init(hardwareMap);
        Robot.gamepadInit(gamepad1, gamepad2);

        Pose2d firstPose=new Pose2d(-34.5,-58,90);
        Pose2d RightLane=new Pose2d(-29,-33,60);
        Pose2d LeftStack=new Pose2d(-53,-36,0);
        Pose2d BackboardRight=new Pose2d(48,-41.31,0);
        Pose2d RightStack=new Pose2d(-56.45,-12.02,0);
        Pose2d BackboardLeft=new Pose2d(48,-29.65,0);

            cPose=firstPose;

            Action TrajRightLane = drive.actionBuilder(cPose, Math.toRadians(0))  //Traiectorie pana la linea din dreapta
                    .setReversed(false)
                    .splineToLinearHeading(new Pose2d(-29, -33, Math.toRadians(60)), Math.toRadians(60))
                    .build();

            cPose=RightLane;

            Action TrajLeftStack = drive.actionBuilder(cPose,Math.toRadians(90))  //Traiectorie pana la Stackul din stanga
                    .setReversed(true)
                    .splineToLinearHeading(new Pose2d(-56.45,-36,Math.toRadians(0)),Math.toRadians(90))
                    .afterDisp(1, new SequentialAction(
                            new ParallelAction(
                                    Robot.Intake("in"),
                                    Robot.maturiceOpen_Close("open"),
                                    Robot.maturiceLevel("Level5")
                            )
                    ))
                    .build();

        cPose=LeftStack;

        Action TrajToBackboardRight = drive.actionBuilder(cPose, Math.toRadians(0))  //Traiectorie pana la backboard dreapta
                .setTangent(Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(-38.39, -12.02, Math.toRadians(0)), Math.toRadians(0))
                .splineToLinearHeading(new Pose2d(27, -12.02, Math.toRadians(0)), Math.toRadians(0))
                .splineToLinearHeading(new Pose2d(48, -41.31, Math.toRadians(0)), Math.toRadians(0))
                /*.afterDisp(10, new SequentialAction(
                        Robot.misum("MIDDLE"),
                        Robot.turnOutake("turn"),
                        Robot.openOutake("open"),
                        Robot.openOutake("close"),
                        Robot.turnOutake("noTurn"),
                        Robot.misum("GROUND")
                ))*/
                .afterDisp(15,new SequentialAction(
                        Robot.misum("MIDDLE"),
                        new SleepAction(0.6),
                        Robot.turnOutake("turn")
                ))
                .build();

            cPose=BackboardRight;

            //Level 1 2 3 4 5 6
            Action TrajRightStackLevel6 = drive.actionBuilder(cPose, Math.toRadians(180))  //Traiectorie pana la stackul din dreapta nivel 6 (teoretic nu ia pixel)
                    .setReversed(true)
                    .splineToLinearHeading(new Pose2d(27, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    .splineToLinearHeading(new Pose2d(-56.45, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    /*.afterDisp(10, new SequentialAction(
                            new ParallelAction(
                                    Robot.Intake("in"),
                                    Robot.maturiceOpen_Close("in"),
                                    Robot.maturiceLevel("Level6")
                            ),
                            Robot.maturiceOpen_Close("off")
                    ))*/
                    .afterDisp(10,new SequentialAction(
                            Robot.Intake("in"),
                            Robot.maturiceOpen_Close("in"),
                            Robot.maturiceLevel("Level6")
                            //Robot.maturiceOpen_Close("off")
                    ))
                    .build();

            cPose=BackboardRight;

            Action TrajRightStackLevel5 = drive.actionBuilder(cPose, Math.toRadians(180))  //Traiectorie pana la stackul din dreapta nivel 5
                .setReversed(true)
                .splineToLinearHeading(new Pose2d(27, -12.02, Math.toRadians(0)), Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-56.45, -12.02, Math.toRadians(0)), Math.toRadians(180))
                /*.afterDisp(10, new SequentialAction(
                        new ParallelAction(
                                Robot.Intake("in"),
                                Robot.maturiceOpen_Close("in"),
                                Robot.maturiceLevel("Level5")
                        ),
                        Robot.maturiceOpen_Close("off")
                ))*/
                    .afterDisp(10,new SequentialAction(
                            new ParallelAction(
                                    Robot.Intake("in"),
                                    Robot.maturiceOpen_Close("in"),
                                    Robot.maturiceLevel("Level5")
                                    //Robot.maturiceOpen_Close("off")
                            )
                    ))
                    .build();

            cPose=BackboardRight;

            Action TrajRightStackLevel4 = drive.actionBuilder(cPose, Math.toRadians(180))  //Traiectorie pana la stackul din dreapta nivel 4
                    .setReversed(true)
                    .splineToLinearHeading(new Pose2d(27, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    .splineToLinearHeading(new Pose2d(-56.45, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    /*.afterDisp(10, new SequentialAction(
                            new ParallelAction(
                                    Robot.Intake("in"),
                                    Robot.maturiceOpen_Close("in"),
                                    Robot.maturiceLevel("Level4")
                            ),
                            Robot.maturiceOpen_Close("off")
                    ))*/
                    .afterDisp(10,new SequentialAction(
                            new ParallelAction(
                                    Robot.Intake("in"),
                                    Robot.maturiceOpen_Close("in"),
                                    Robot.maturiceLevel("Level4")
                                    //Robot.maturiceOpen_Close("off")
                            )
                    ))
                    .build();

            cPose=BackboardRight;

            Action TrajRightStackLevel3 = drive.actionBuilder(cPose, Math.toRadians(180))  //Traiectorie pana la stackul din dreapta nivel 3
                    .setReversed(true)
                    .splineToLinearHeading(new Pose2d(27, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    .splineToLinearHeading(new Pose2d(-56.45, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    /*.afterDisp(10, new SequentialAction(
                            new ParallelAction(
                                    Robot.Intake("in"),
                                    Robot.maturiceOpen_Close("in"),
                                    Robot.maturiceLevel("Level3")
                            ),
                            Robot.maturiceOpen_Close("off")
                    ))*/
                    .afterDisp(10,new SequentialAction(
                            new ParallelAction(
                                    Robot.Intake("in"),
                                    Robot.maturiceOpen_Close("in"),
                                    Robot.maturiceLevel("Level3")
                                    //Robot.maturiceOpen_Close("off")
                            )
                    ))
                    .build();

            cPose=BackboardRight;

            Action TrajRightStackLevel2 = drive.actionBuilder(cPose, Math.toRadians(180))  //Traiectorie pana la stackul din dreapta nivel 2
                    .setReversed(true)
                    .splineToLinearHeading(new Pose2d(27, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    .splineToLinearHeading(new Pose2d(-56.45, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    /*.afterDisp(10, new SequentialAction(
                            new ParallelAction(
                                    Robot.Intake("in"),
                                    Robot.maturiceOpen_Close("in"),
                                    Robot.maturiceLevel("Level2")
                            ),
                            Robot.maturiceOpen_Close("off")
                    ))*/
                    .afterDisp(10,new SequentialAction(
                            new ParallelAction(
                                    Robot.Intake("in"),
                                    Robot.maturiceOpen_Close("in"),
                                    Robot.maturiceLevel("Level2")
                                    //Robot.maturiceOpen_Close("off")
                            )
                    ))
                    .build();

            cPose=BackboardRight;

            Action TrajRightStackLevel1 = drive.actionBuilder(cPose, Math.toRadians(180))  //Traiectorie pana la stackul din dreapta nivel 1
                    .setReversed(true)
                    .splineToLinearHeading(new Pose2d(27, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    .splineToLinearHeading(new Pose2d(-56.45, -12.02, Math.toRadians(0)), Math.toRadians(180))
                    /*.afterDisp(10, new SequentialAction(
                            new ParallelAction(
                                    Robot.Intake("in"),
                                    Robot.maturiceOpen_Close("in"),
                                    Robot.maturiceLevel("Level1")
                            ),
                            Robot.maturiceOpen_Close("off")
                    ))*/
                    .afterDisp(10,new SequentialAction(
                            new ParallelAction(
                                    Robot.Intake("in"),
                                    Robot.maturiceOpen_Close("in"),
                                    Robot.maturiceLevel("Level1")
                                    //Robot.maturiceOpen_Close("off")
                            )
                    ))
                    .build();

            cPose=RightStack;

            Action TrajToBackboardLeft = drive.actionBuilder(cPose, Math.toRadians(0))  //Traiectorie pana la backboard stanga
                    .setReversed(false)
                    .splineToLinearHeading(new Pose2d(27, -12.02, Math.toRadians(0)), Math.toRadians(0))
                    .splineToLinearHeading(new Pose2d(48, -29.65, Math.toRadians(0)), Math.toRadians(0))
                    /*.afterDisp(10, new ParallelAction(
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
                    ))*/
                    .afterDisp(10,new SequentialAction(
                            Robot.misum("MIDDLE"),
                            new SleepAction(0.6),
                            Robot.turnOutake("turn")
                            /*Robot.openOutake("open"),
                            Robot.openOutake("close"),
                            Robot.turnOutake("noTurn"),
                            Robot.misum("GROUND")*/
                    ))
                    .build();

            cPose=BackboardLeft;

            Action ParkingLeft = drive.actionBuilder(cPose, Math.toRadians(90))  //Traiectorie parcare stanga
                    .setReversed(true)
                    .setTangent(Math.toRadians(90))
                    .splineToSplineHeading(new Pose2d(48, -15, Math.toRadians(0)), Math.toRadians(90))
                    .afterDisp(0.1, new SequentialAction(
                            new ParallelAction(
                                    Robot.hook1("open"),
                                    Robot.hook2("open")
                            ),
                            new SleepAction(0.2),
                            Robot.openOutake("close"),
                            new SleepAction(0.1),
                            Robot.turnOutake("noTurn"),
                            new ParallelAction(
                                    Robot.maturiceOpen_Close("off"),
                                    Robot.Intake("off")
                            ),
                            Robot.misum("GROUND")
                    ))
                    .build();

            waitForStart();
            Actions.runBlocking(new SequentialAction( //Face actiunile una dupa cealalta
                    Robot.hook2("pixel"), //pixelul din cuva

                    TrajRightLane,
                    new SleepAction(0.2),

                    TrajLeftStack,
                    new ParallelAction(
                            Robot.maturiceOpen_Close("off"),
                            Robot.Intake("off")
                    ),
                    Robot.hook1("close"),  //Pixelul de jos (in cel de sus este deja un pixel)

                    TrajToBackboardRight,
                    Robot.openOutake("open"),
                    new SleepAction(0.2),
                    new ParallelAction(
                            Robot.hook1("open"),
                            Robot.hook2("open")      //Las pixelii sa cada
                    ),
                    new SleepAction(0.2),
                    new ParallelAction(
                            Robot.hook1("close"),
                            Robot.hook2("close")
                    ),
                    new SleepAction(0.3),
                    Robot.openOutake("close"),
                    new SleepAction(0.2),
                    Robot.turnOutake("noTurn"),
                    new SleepAction(0.3),
                    Robot.misum("GROUND"),

                    TrajRightStackLevel4,
                    new ParallelAction(
                            Robot.maturiceOpen_Close("off"),
                            Robot.Intake("off")
                    ),
                    new ParallelAction(
                            Robot.hook1("close"),
                            Robot.hook2("close")
                    ),

                    TrajToBackboardLeft,
                    Robot.openOutake("open"),
                    new SleepAction(0.2),
                    new ParallelAction(
                            Robot.hook1("open"),
                            Robot.hook2("open")      //Las pixelii sa cada
                    ),
                    new SleepAction(0.2),
                    new ParallelAction(
                            Robot.hook1("close"),
                            Robot.hook2("close")
                    ),
                    new SleepAction(0.3),
                    Robot.openOutake("close"),
                    new SleepAction(0.2),
                    Robot.turnOutake("noTurn"),
                    new SleepAction(0.3),
                    Robot.misum("GROUND"),

                    TrajRightStackLevel2,
                    new ParallelAction(
                            Robot.maturiceOpen_Close("off"),
                            Robot.Intake("off")
                    ),

                    TrajToBackboardLeft,
                    Robot.openOutake("open"),
                    new SleepAction(0.2),
                    new ParallelAction(
                            Robot.hook1("open"),
                            Robot.hook2("open")      //Las pixelii sa cada
                    ),
                    new SleepAction(0.2),
                    new ParallelAction(
                            Robot.hook1("close"),
                            Robot.hook2("close")
                    ),
                    new SleepAction(0.3),
                    Robot.openOutake("close"),
                    new SleepAction(0.2),
                    Robot.turnOutake("noTurn"),
                    new SleepAction(0.3),
                    Robot.misum("GROUND"),

                    ParkingLeft
            ));

            while(opModeIsActive() && !isStopRequested()){
                telemetry.addData("x :",drive.pose.position.x);
                telemetry.addData("y :",drive.pose.position.y);
                telemetry.addData("Current Pose :",cPose);
            }
    }
}