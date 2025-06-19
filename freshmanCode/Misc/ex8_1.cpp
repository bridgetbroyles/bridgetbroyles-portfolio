#include <BnrOneAPlus.h>
#include <SPI.h>

#define SSPIN 2

BnrOneAPlus one;

class MotorMenu {
public:
  MotorMenu() {
    _lastButton = 0;
    _whichMotor = 0;
    _leftSpeed = _rightSpeed = 0;
  }

  void buttonPress(byte button) {
    switch(button) {
      case 0:
        break;
      case 1: 
        if (_lastButton != button) {
          _whichMotor = !_whichMotor;
        }
        break;
      case 2:
        if (_whichMotor) {
          _rightSpeed = min(_rightSpeed + 1, 100);
        } else {
          _leftSpeed  = min(_leftSpeed  + 1, 100);
        }
        break;
      case 3:
        if (_whichMotor) {
          _rightSpeed = max(_rightSpeed - 1, -100);
        } else {
          _leftSpeed  = max(_leftSpeed  - 1, -100);
        }
        break;
    }
    _lastButton = button;
  }

  void runMotors() {
    one.move(_leftSpeed, _rightSpeed);
  }

  void printMenu() {
    String lineOne = String(_leftSpeed) + "  " + String(_rightSpeed);
    one.lcd1(lineOne);
    one.lcd2(_whichMotor ? "--->" : "<---");
  }

protected:
  byte  _lastButton;
  bool  _whichMotor;
  int   _leftSpeed, _rightSpeed;
};

MotorMenu menu;

class TurnAndPush {
public:
  TurnAndPush(int thresh) : threshold(thresh) {}

  void reactToObstacles() {
    int leftO  = one.readLeftRangeSensor();
    int rightO = one.readRightRangeSensor();
    byte obstacleDetection;
    if (leftO  <= threshold && rightO <= threshold) {
      obstacleDetection = 0;
    }
    else if (leftO  > threshold && rightO <= threshold) {
      obstacleDetection = 1;
    }
    else if (leftO  <= threshold && rightO > threshold) {
      obstacleDetection = 2;
    }
    else {
      obstacleDetection = 3;
    }
    switch (obstacleDetection) {
      case 0: one.lcd1("No obstacle"); break;
      case 1: one.lcd1("Left");        break;
      case 2: one.lcd1("Right");       break;
      case 3: one.lcd1("Both");        break;
    }
  }

private:
  int threshold;
};

TurnAndPush tp(300);

void setup() {
  Serial.begin(115200);
  one.spiConnect(SSPIN);
  one.stop();
  one.obstacleSensorsEmitters(true);
}

void loop() {
  tp.reactToObstacles();
  delay(100);
}
