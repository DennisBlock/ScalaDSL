object MathDSL {
	implicit class Test(x: Int) {
		def plus(y: Int) = 	x + y
		def minus(y: Int) = x - y
		def mal(y: Int) = x * y
		def durch(y: Int) = x / y
	}
	
	def test(x: Int, y: Int) = x * y          //> test: (x: Int, y: Int)Int
	def testx(x: Int) = x*2                   //> testx: (x: Int)Int
	var x = 2 plus 1                          //> x  : Int = 3
	var y = 5 plus 1                          //> y  : Int = 6
	var z = 1                                 //> z  : Int = 1
	var e = 2                                 //> e  : Int = 2
	
	testx(2)                                  //> res0: Int = 4
	
	2.+(2)                                    //> res1: Double(4.0) = 4.0
	
	z.+(2)                                    //> res2: Int = 3
	
	2 mal 2 plus 6                            //> res3: Int = 10
	2 plus 2 mal 3                            //> res4: Int = 12
}