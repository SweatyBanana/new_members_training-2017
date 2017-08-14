package org.firstinspires.ftc.teamcode.tutorial;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Student on 8/14/2017.
 */
public class PracticeProblem {

    @Autonomous(name="AutonomousPractice")
    @Disabled

    public class AutonomousPractice extends LinearOpMode {

        private DcMotor leftMotor;
        private DcMotor rightMotor;

        @Override
        public void runOpMode() throws InterruptedException {

            leftMotor = hardwareMap.dcMotor.get("left_drive");
            rightMotor = hardwareMap.dcMotor.get("right_drive");
            leftMotor.setDirection(DcMotor.Direction.REVERSE);
        }
    }

    public void arcadeDrive(double power, double turn) { //Double power lets us use decimals
        double leftPower = Range.clip(power + turn, -1, 1);
        double rightPower = Range.clip(power - turn, -1, 1);

        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);
    }


}

