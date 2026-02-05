package com.mjc813.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Driving {
	private Driver lsh;
	private Avante avanteMD;

	public void go(int accelatorPedal) {
		try {
			this.avanteMD.setSpeed(accelatorPedal * 10);
		} catch (Exception ex) {
			System.err.println(ex.toString());
			this.avanteMD = new Avante("MD5", "black");
		} finally {
			try {
				System.out.printf("%s 운전수가 %s 자동차를 운전하여 액셀 %d 밟아서 스피드 %d 가 됐습니다..\n"
						, this.lsh.getName(), this.avanteMD.getModelName()
						, accelatorPedal, this.avanteMD.getSpeed()
				);
			} catch (Exception ex) {
				System.err.println(ex.toString());
				this.lsh = new Driver("이승협");
			} finally {
				System.out.printf("%s 운전수가 %s 자동차를 운전하여 액셀 %d 밟아서 스피드 %d 가 됐습니다..\n"
						, this.lsh.getName(), this.avanteMD.getModelName()
						, accelatorPedal, this.avanteMD.getSpeed()
				);
			}
		}
	}

	public void stop(int breakPedal) {
		try {
			this.avanteMD.setSpeed( -(breakPedal * 10) );
		} catch (Exception ex) {
			System.err.println(ex.toString());
			this.avanteMD = new Avante("HD5", "red");
		} finally {
			try {
				System.out.printf("%s 운전수가 %s 자동차를 운전하여 브레이크 %d 밟아서 스피드 %d 가 됐습니다..\n"
						, this.lsh.getName(), this.avanteMD.getModelName()
						, breakPedal, this.avanteMD.getSpeed()
				);
			} catch (Exception ex) {
				System.err.println(ex.toString());
				this.lsh = new Driver("최원철");
			} finally {
				System.out.printf("%s 운전수가 %s 자동차를 운전하여 브레이크 %d 밟아서 스피드 %d 가 됐습니다..\n"
						, this.lsh.getName(), this.avanteMD.getModelName()
						, breakPedal, this.avanteMD.getSpeed()
				);
			}
		}
	}
}
