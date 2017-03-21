package persistence;

public class Block {
    
     int coordinateX;
     int coordinateY;
     int coordinateZ;
     int value;
    
    public Block(int coordinateX,int coordinateY, int coordinateZ, int value){
    this.coordinateX= coordinateX;
    this.coordinateY= coordinateY;
    this.coordinateZ= coordinateZ;
    this.value = value;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public int getCoordinateZ() {
        return coordinateZ;
    }

    public void setCoordinateZ(int coordinateZ) {
        this.coordinateZ = coordinateZ;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
        
    
}

