public class Polynomial {
    private double[] coefficients;

    public Polynomial(){
        this.coefficients = new double[1];
    }

    public Polynomial(double[] coeffs){
        this.coefficients = new double[coeffs.length];
        for(int i = 0; i < coeffs.length; i++){
            this.coefficients[i] = coeffs[i];
        }
    }

    public Polynomial add(Polynomial a){
        double[] temp;
        if(a.coefficients.length > this.coefficients.length){
            temp = new double[a.coefficients.length];
            for(int i = 0; i < this.coefficients.length; i++){
                temp[i] = this.coefficients[i] + a.coefficients[i];
            }
            
            for(int i = this.coefficients.length; i < a.coefficients.length; i++){
                temp[i] = + a.coefficients[i];
            }

        }
        else{
            temp = new double[this.coefficients.length];
            for(int i = 0; i < a.coefficients.length; i++){
                temp[i] = this.coefficients[i] + a.coefficients[i];
            }
            
            for(int i = a.coefficients.length; i < this.coefficients.length; i++){
                temp[i] = this.coefficients[i];
            }
        }
        
        Polynomial sum = new Polynomial(temp);
        return sum;
    }

    public double evaluate(double x){
        double sum = 0;
        double xPow;
        for(int i = 0; i < this.coefficients.length; i++){
            xPow = 1;
            for(int j = 0; j < i; j++){
                xPow = xPow*x;
            }
            sum += coefficients[i] * xPow;
        }
        return sum;
    }

    public boolean hasRoot(double root){
        return evaluate(root) == 0.0;
    }
}
