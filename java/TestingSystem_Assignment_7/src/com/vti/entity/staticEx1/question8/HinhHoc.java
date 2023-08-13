package com.vti.entity.staticEx1.question8;

public abstract class HinhHoc implements IHinhHoc {

	private static int counter = 0;

	private float a;
	private float b;

	public HinhHoc(float a, float b) throws Exception {
		if (counter > Configs.SO_LUONG_HINH_TOI_DA) {
			throw new Exception("Số lượng hình tối đa là: " + Configs.SO_LUONG_HINH_TOI_DA);
		}

		this.a = a;
		this.b = b;
	}
}
