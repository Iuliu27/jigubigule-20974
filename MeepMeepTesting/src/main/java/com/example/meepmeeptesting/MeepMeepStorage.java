package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepStorage {
    MeepMeep meepMeep = new MeepMeep(600);
    RoadRunnerBotEntity AutoRedStanga3Up = new DefaultBotBuilder(meepMeep)   //Gata
            // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
            .setConstraints(45, 50, Math.toRadians(180), Math.toRadians(180), 15.1)
            .followTrajectorySequence(driveShim ->
                    driveShim.trajectorySequenceBuilder(new Pose2d(-34.5, -58 , Math.toRadians(90)))

                            .setReversed(false)
                            .splineToLinearHeading(new Pose2d(-29, -33, Math.toRadians(60)), Math.toRadians(60))
                            .waitSeconds(0.2)
                            .setReversed(true)
                            .splineToLinearHeading(new Pose2d(-56.45,-36,Math.toRadians(0)),Math.toRadians(90))
                            .waitSeconds(0.7) //ia un pixel
                            //1
                            .setTangent(Math.toRadians(90))
                            .splineToLinearHeading(new Pose2d(-38.39, -12.02,Math.toRadians(0)), Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(27, -12.02,Math.toRadians(0)), Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(48, -41.31,Math.toRadians(0)), Math.toRadians(0))
                            .waitSeconds(0.7)
                            .setReversed(true)
                            .splineToLinearHeading(new Pose2d(27, -12.02,Math.toRadians(0)), Math.toRadians(180))
                            .splineToLinearHeading(new Pose2d(-56.45, -12.02,Math.toRadians(0)), Math.toRadians(180))
                            .waitSeconds(0.7)
                            .setReversed(false)
                            .splineToLinearHeading(new Pose2d(27, -12.02,Math.toRadians(0)), Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(48, -29.65,Math.toRadians(0)), Math.toRadians(0))
                            .waitSeconds(0.7)
                            .setReversed(true)
                            .splineToLinearHeading(new Pose2d(27, -12.02,Math.toRadians(0)), Math.toRadians(180))
                            .splineToLinearHeading(new Pose2d(-56.45, -12.02,Math.toRadians(0)), Math.toRadians(180))
                            .setReversed(false)
                            .waitSeconds(0.7)
                            .splineToLinearHeading(new Pose2d(27, -12.02,Math.toRadians(0)), Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(48, -29.65,Math.toRadians(0)), Math.toRadians(0))
                            .waitSeconds(0.7)
                            //de final
                            .setReversed(true)
                            .setTangent(Math.toRadians(90))
                            .splineToSplineHeading(new Pose2d(48,-15,Math.toRadians(0)),Math.toRadians(90))
                            .build()
            );

    RoadRunnerBotEntity AutoRedStanga3Down = new DefaultBotBuilder(meepMeep) //Gata
            .setConstraints(45, 50, Math.toRadians(180), Math.toRadians(180), 15.1)
            .followTrajectorySequence(driveShim ->
                    driveShim.trajectorySequenceBuilder(new Pose2d(-34.5  , -58 , Math.toRadians(90)))

                            .setReversed(false)
                            .splineToLinearHeading(new Pose2d(-29, -33, Math.toRadians(60)), Math.toRadians(60))
                            .waitSeconds(0.2)
                            .setReversed(true)
                            .splineToLinearHeading(new Pose2d(-53,-36,Math.toRadians(0)),Math.toRadians(180))
                            .waitSeconds(0.7) //ia un pixel
                            //1
                            .setTangent(Math.toRadians(90))
                            .setReversed(false)
                            .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(48,-42,Math.toRadians(0)),Math.toRadians(0))
                            .waitSeconds(0.7)
                            .setReversed(true)
                            .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(180))
                            .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(180))
                            .splineToLinearHeading(new Pose2d(-53,-36,Math.toRadians(0)),Math.toRadians(180))
                            .waitSeconds(0.7)
                            .setReversed(false)
                            .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(48,-42,Math.toRadians(0)),Math.toRadians(0))
                            .waitSeconds(0.7)
                            .setReversed(true)
                            .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(180))
                            .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(180))
                            .splineToLinearHeading(new Pose2d(-53,-36,Math.toRadians(0)),Math.toRadians(180))
                            .waitSeconds(0.7)
                            .setReversed(false)
                            .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(48,-42,Math.toRadians(0)),Math.toRadians(0))
                            .waitSeconds(0.7)

                            //de final
                            .setReversed(true)
                            .setTangent(Math.toRadians(-90))
                            .splineToSplineHeading(new Pose2d(48,-56,Math.toRadians(0)),Math.toRadians(270))
                            .build()
            );

    RoadRunnerBotEntity AutoRedStanga1Up=new DefaultBotBuilder(meepMeep)
            .setConstraints(45, 50, Math.toRadians(180), Math.toRadians(180), 15.1)
            .followTrajectorySequence(driveShim ->
                    driveShim.trajectorySequenceBuilder(new Pose2d(-34.5, -58 , Math.toRadians(90)))

                            .setReversed(false)
                            .splineToLinearHeading(new Pose2d(-39,-36,Math.toRadians(120)),Math.toRadians(90))
                            .waitSeconds(0.2)
                            //.setReversed(true)
                            .setTangent(Math.toRadians(90))
                            .splineToLinearHeading(new Pose2d(-37,-45,Math.toRadians(90)),Math.toRadians(90))
                            .setReversed(false)
                            .splineToLinearHeading(new Pose2d(-58,-36,Math.toRadians(0)),Math.toRadians(90))
                            .waitSeconds(0.7) //ia un pixel
                            //1
                            .setTangent(Math.toRadians(90))
                            .splineToLinearHeading(new Pose2d(-49, -12.02,Math.toRadians(0)), Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(27, -12.02,Math.toRadians(0)), Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(48, -29.65,Math.toRadians(0)), Math.toRadians(0))
                            .waitSeconds(0.7)
                            .setReversed(true)
                            .splineToLinearHeading(new Pose2d(27, -12.02,Math.toRadians(0)), Math.toRadians(180))
                            .splineToLinearHeading(new Pose2d(-56.45, -12.02,Math.toRadians(0)), Math.toRadians(180))
                            .setReversed(false)
                            .waitSeconds(0.7)
                            .splineToLinearHeading(new Pose2d(27, -12.02,Math.toRadians(0)), Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(48, -29.65,Math.toRadians(0)), Math.toRadians(0))
                            .waitSeconds(0.7)
                            .setReversed(true)
                            .splineToLinearHeading(new Pose2d(27, -12.02,Math.toRadians(0)), Math.toRadians(180))
                            .splineToLinearHeading(new Pose2d(-56.45, -12.02,Math.toRadians(0)), Math.toRadians(180))
                            .setReversed(false)
                            .waitSeconds(0.7)
                            .splineToLinearHeading(new Pose2d(27, -12.02,Math.toRadians(0)), Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(48, -29.65,Math.toRadians(0)), Math.toRadians(0))
                            .waitSeconds(0.7)
                            //de final
                            .setReversed(true)
                            .setTangent(Math.toRadians(90))
                            .splineToLinearHeading(new Pose2d(48,-15,Math.toRadians(0)),Math.toRadians(90))
                            .build()
            );

    RoadRunnerBotEntity AutoRedStanga1Down=new DefaultBotBuilder(meepMeep)
            .setConstraints(45, 50, Math.toRadians(180), Math.toRadians(180), 15.1)
            .followTrajectorySequence(driveShim ->
                    driveShim.trajectorySequenceBuilder(new Pose2d(-34.5, -58 , Math.toRadians(90)))
                            .setReversed(false)
                            .splineToLinearHeading(new Pose2d(-39,-36,Math.toRadians(120)),Math.toRadians(90))
                            .waitSeconds(0.2)
                            //.setReversed(true)
                            .setTangent(Math.toRadians(90))
                            .splineToLinearHeading(new Pose2d(-37,-45,Math.toRadians(90)),Math.toRadians(90))
                            .setReversed(false)
                            .splineToLinearHeading(new Pose2d(-58,-36,Math.toRadians(0)),Math.toRadians(90))
                            .waitSeconds(0.7) //ia un pixel
                            //1
                            .setTangent(Math.toRadians(90))
                            .setReversed(false)
                            .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(48,-42,Math.toRadians(0)),Math.toRadians(0))
                            .waitSeconds(0.7)
                            .setReversed(true)
                            .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(180))
                            .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(180))
                            .splineToLinearHeading(new Pose2d(-58,-36,Math.toRadians(0)),Math.toRadians(180))
                            .waitSeconds(0.7)
                            .setReversed(false)
                            .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(48,-42,Math.toRadians(0)),Math.toRadians(0))
                            .waitSeconds(0.7)
                            .setReversed(true)
                            .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(180))
                            .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(180))
                            .splineToLinearHeading(new Pose2d(-58,-36,Math.toRadians(0)),Math.toRadians(180))
                            .waitSeconds(0.7)
                            .setReversed(false)
                            .splineToLinearHeading(new Pose2d(-33,-59,Math.toRadians(0)),Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(27,-59,Math.toRadians(0)),Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(48,-42,Math.toRadians(0)),Math.toRadians(0))
                            .waitSeconds(0.7)

                            //de final
                            .setReversed(true)
                            .setTangent(Math.toRadians(-90))
                            .splineToSplineHeading(new Pose2d(48,-56,Math.toRadians(0)),Math.toRadians(270))
                            .build()
            );


    RoadRunnerBotEntity AutoRedDreapta1Up=new DefaultBotBuilder(meepMeep)
            .setConstraints(45, 50, Math.toRadians(180), Math.toRadians(180), 15.1)
            .followTrajectorySequence(driveShim ->
                    driveShim.trajectorySequenceBuilder(new Pose2d(11, -66 , Math.toRadians(90)))

                            .setReversed(false)
                            .splineToLinearHeading(new Pose2d(5.62,-37,Math.toRadians(115)),Math.toRadians(90))
                            .setTangent(Math.toRadians(0))
                            .setReversed(true)
                            .splineToSplineHeading(new Pose2d(21, -43, Math.toRadians(0)), Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(48, -30, Math.toRadians(0)), Math.toRadians(0))
                            .waitSeconds(0.7)
                            .setReversed(true)
                            .splineToLinearHeading(new Pose2d(27, -12.02,Math.toRadians(0)), Math.toRadians(180))
                            .splineToLinearHeading(new Pose2d(-56.45, -12.02,Math.toRadians(0)), Math.toRadians(180))
                            .setReversed(false)
                            .waitSeconds(0.7)
                            .splineToLinearHeading(new Pose2d(27, -12.02,Math.toRadians(0)), Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(48, -29.65,Math.toRadians(0)), Math.toRadians(0))
                            .waitSeconds(0.7)
                            .setReversed(true)
                            .splineToLinearHeading(new Pose2d(27, -12.02,Math.toRadians(0)), Math.toRadians(180))
                            .splineToLinearHeading(new Pose2d(-56.45, -12.02,Math.toRadians(0)), Math.toRadians(180))
                            .setReversed(false)
                            .waitSeconds(0.7)
                            .splineToLinearHeading(new Pose2d(27, -12.02,Math.toRadians(0)), Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(48, -29.65,Math.toRadians(0)), Math.toRadians(0))
                            .waitSeconds(0.7)
                            //de final
                            .setReversed(true)
                            .setTangent(Math.toRadians(90))
                            .splineToLinearHeading(new Pose2d(48,-15,Math.toRadians(0)),Math.toRadians(90))
                            .build()
            );

    RoadRunnerBotEntity AutoRedDreapta1Down=new DefaultBotBuilder(meepMeep)
            .setConstraints(45, 50, Math.toRadians(180), Math.toRadians(180), 15.1)
            .followTrajectorySequence(driveShim ->
                    driveShim.trajectorySequenceBuilder(new Pose2d(11, -66 , Math.toRadians(90)))
                            .setReversed(false)
                            .splineToLinearHeading(new Pose2d(5.62,-37,Math.toRadians(115)),Math.toRadians(90))
                            .setTangent(Math.toRadians(0))
                            .setReversed(true)
                            .splineToSplineHeading(new Pose2d(21, -43, Math.toRadians(0)), Math.toRadians(0))
                            .splineToLinearHeading(new Pose2d(48, -30, Math.toRadians(0)), Math.toRadians(0))
                            .waitSeconds(0.7) //pune pixelul
                            .splineToLinearHeading(new Pose2d(2,-59,Math.toRadians(0)),Math.toRadians(180))
                            .splineToLinearHeading(new Pose2d(-54,-59,Math.toRadians(0)),Math.toRadians(180))
                            .build()
            );
    RoadRunnerBotEntity AutoTesting=new DefaultBotBuilder(meepMeep)
            .setConstraints(45, 50, Math.toRadians(180), Math.toRadians(180), 15.1)
            .followTrajectorySequence(driveShim ->
                    driveShim.trajectorySequenceBuilder(new Pose2d(-34.5, -58 , Math.toRadians(90)))
                            .setReversed(false)
                            .splineToLinearHeading(new Pose2d(-39,-36,Math.toRadians(120)),Math.toRadians(90))
                            .waitSeconds(0.2)
                            //.setReversed(true)
                            .setTangent(Math.toRadians(90))
                            .splineToLinearHeading(new Pose2d(-37,-45,Math.toRadians(120)),Math.toRadians(90))
                            .setReversed(false)
                            .splineToLinearHeading(new Pose2d(-58,-36,Math.toRadians(0)),Math.toRadians(90))
                            .waitSeconds(0.7) //ia un pixel
                            .build()
            );
}