package implementingPackages;

public class DynamicStack extends CustomStack{

    public DynamicStack(){
        super(); // this calls the
    }

    public DynamicStack(int size){
        super(size);
    }

    public boolean push(int item){

        if(this.isFull()){
            // double the array size
            int[] newData = new int[data.length*2];

            for(int i = 0; i < data.length; i++){
                newData[i] = data[i];
            }

            data = newData;
        }

        return super.push(item);
    }

}
