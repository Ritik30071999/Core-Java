package com.app;

public abstract class ShapeRuntime {
	float length, width, height;

	void setDim(float length, float width, float height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}

	abstract float calArea();

}
