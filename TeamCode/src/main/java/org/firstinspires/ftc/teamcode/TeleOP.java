package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
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
    public int ok= 0;

    //HardwareMapping hw=new HardwareMapping();
    private MecanumDrive drive;

    /**
     *  DRIVER 1
     *   X         - Power on/off INTAKE
     *   Y         - Engage hooks on/off
     *   B         - Hanging
     *   A         - Rotate outtake 90 degrees
     *   Left/Right stick - Base controls
     *   Right stick press down - Launch plane
     *   DPAD left     - Lift ground
     *   DPAD down     - Lift 1st level
     *   DPAD right    - Lift 2nd level
     *   DPAD up       - Lift 3rd level
     *   LEFT/RIGHT BUMPER - Change intake angle
     *
     *   DRIVER 2
     *   X         - Power on/off INTAKE
     *   Y         - Engage hooks on/off
     *   B         - Reverse intake
     *   A         - Rotate outtake 90 degrees
     *   Left stick Y - manual slide control
     *   Left stick X - manual outtake pitch (keep 60 degree angle (in progress))
     *   Right stick press down - Launch plane
     *   DPAD left     - Lift ground
     *   DPAD down     - Lift 1st level
     *   DPAD right    - Lift 2nd level
     *   DPAD up       - Lift 3rd level
     *   LEFT/RIGHT BUMPER - Change intake angle
     *   BACK          - Change movement mode
     *   START         - Change HEADING_LOCK target 0/180
     *
     *       _=====_                               _=====_
     *      / _____ \                             / _____ \
     *    +.-'_____'-.---------------------------.-'_____'-.+
     *   /   |     |  '.                       .'  |  _  |   \
     *  / ___| /|\ |___ \    BACK     START   / ___| (Y) |___ \
     * / |      |      | ;                   ; |              | ;
     * | | <---   ---> | |                   | |(X)       (B) | |
     * | |___   |   ___| ;  MODE             ; |___        ___| ;
     * |\    | \|/ |    /  _              _   \    | (A) |    /|
     * | \   |_____|  .','" "',        ,'" "', '.  |_____|  .' |
     * |  '-.______.-' /       \      /       \  '-._____.-'   |
     * |               |       |------|       |                |
     * |              /\       /      \       /\               |
     * |             /  '.___.'        '.___.'  \              |
     * |            /                            \             |
     *  \          /                              \           /
     *   \________/                                \_________/
     */

    @Override
    public void runOpMode() throws InterruptedException {

        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        double TriggerSlowdown=gamepad2.right_trigger,heading=180;
        Robot.init(hardwareMap);
        Robot.gamepadInit(gamepad1, gamepad2);

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

            if(Robot.gamepad1Ex.wasJustPressed(GamepadKeys.Button.X)){
                if(ok==0){
                    ok=1;
                    runningActions.add(new SequentialAction(
                            Robot.Intake("lessThan2Pixels")
                    ));
                }
                else{
                    ok=0;
                    runningActions.add(new SequentialAction(
                            Robot.Intake("moreThan2Pixels")
                    ));
                }
            }
            if(Robot.gamepad1Ex.wasJustPressed(GamepadKeys.Button.Y)) {

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