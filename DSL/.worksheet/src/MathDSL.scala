object MathDSL {
	implicit class Test(x: Int) {
		def plus(y: Int) = 	x + y
		def minus(y: Int) = x - y
		def mal(y: Int) = x * y
		def durch(y: Int) = x / y
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(196); 
	
	def test(x: Int, y: Int) = x * y;System.out.println("""test: (x: Int, y: Int)Int""");$skip(25); 
	def testx(x: Int) = x*2;System.out.println("""testx: (x: Int)Int""");$skip(18); 
	var x = 2 plus 1;System.out.println("""x  : Int = """ + $show(x ));$skip(18); 
	var y = 5 plus 1;System.out.println("""y  : Int = """ + $show(y ));$skip(11); 
	var z = 1;System.out.println("""z  : Int = """ + $show(z ));$skip(11); 
	var e = 2;System.out.println("""e  : Int = """ + $show(e ));$skip(12); val res$0 = 
	
	testx(2);System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
	
	2.+(2);System.out.println("""res1: Double(4.0) = """ + $show(res$1));$skip(10); val res$2 = 
	
	z.+(2);System.out.println("""res2: Int = """ + $show(res$2));$skip(18); val res$3 = 
	
	2 mal 2 plus 6;System.out.println("""res3: Int = """ + $show(res$3));$skip(16); val res$4 = 
	2 plus 2 mal 3;System.out.println("""res4: Int = """ + $show(res$4))}
}
