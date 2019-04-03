package com.bsva.settlementv02.dto;

import java.math.BigInteger;

public class TestBigInteger {

	public static void main(String args[]) {
		BigInteger n = new BigInteger("2745285579.09");
		BigInteger one = new BigInteger("100");
		n = n.multiply(one);
		System.out.println(n);
	}
}
