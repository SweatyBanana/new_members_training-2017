package org.firstinspires.ftc.teamcode.tutorial;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


/**
 * Created by Student on 8/12/2017.
 */
// this is a comment
/* this is a
multi lined comment */
@TeleOp(name="TeleOp_Tutorial")

public class teleOptutorial extends OpMode {

    private DcMotor leftMotor;   //DcMotor is a class, the other thing is an object
    private DcMotor rightMotor;
    private Servo arm;

    @Override
    public void init() {         //initialization
        //syntax : variable name = hardwareMap._____.get("name")
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        arm = hardwareMap.servo.get("arm");

        leftMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override //Robot at 0 power before stuff goes down
    public void start() {
        leftMotor.setPower(0.0);
        rightMotor.setPower(0);
        arm.setPosition(0);
    }

    @Override
    public void loop() {             //what the robot does n stuffs

        arcadeDrive(-1*gamepad1.left_stick_y, gamepad1.right_stick_x);
    }

    @Override
    public void stop() {                  //it like.. stops

    }
    public void arcadeDrive(double power, double turn) { //Double power lets us use decimals
        double leftPower = Range.clip(power + turn, -1, 1);
        double rightPower = Range.clip(power- turn, -1, 1);

        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);
    }

}
