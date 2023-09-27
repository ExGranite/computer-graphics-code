public class quiz3 {
    public static void main(String[] args){
        int zone = Zone(-15,44,-42,-3); // find zone
        int[] a1 = ConvertToZone0(-15,44,zone); // convert first endpoint
        int[] a2 = ConvertToZone0(-42,-3,zone); // convert second end point
        System.out.printf("%d, %d, %d, %d%n", a1[0], a1[1], a2[0], a2[1]); // shows zone 0 endpoints
        MidLine(a1[0], a1[1], a2[0], a2[1], zone); // find the pixels to be printed in zone 0 and required zone
    }
    public static int[] ConvertToZone0(int x, int y, int zone){
        int x1 = 0, y1 = 0;
        if(zone == 1){
            x1=y; y1=x;
        }else if(zone == 2){
            x1=y; y1=-x;
        }else if(zone == 3){
            x1=-x; y1=y;
        }else if(zone == 4){
            x1=-x; y1=-y;
        }else if(zone == 5){
            x1=-y; y1=-x;
        }else if(zone == 6){
            x1=-y; y1=x;
        }else if(zone == 7){
            x1=x; y1=-y;
        }else if(zone == 0){
            x1=x; y1=y;
        }
        int[] a = {x1, y1};
        return a;
    }
    public static int[] OriginalZone(int x, int y, int zone){
        int x1 = 0, y1 = 0;
        if(zone == 1){
            x1=y; y1=x;
        }else if(zone == 2){
            x1=-y; y1=x;
        }else if(zone == 3){
            x1=-x; y1=y;
        }else if(zone == 4){
            x1=-x; y1=-y;
        }else if(zone == 5){
            x1=-y; y1=-x;
        }else if(zone == 6){
            x1=y; y1=-x;
        }else if(zone == 7){
            x1=x; y1=-y;
        }else if(zone == 0){
            x1=x; y1=y;
        }
        int[] a = {x1, y1};
        return a;
    }
    public static void MidLine(int x1, int y1, int x2, int y2, int zone){
        int dx = x2 - x1;
        //System.out.println(dx);
        int dy = y2 - y1;
        //System.out.println(dy);
        int dNE = 2 * dy - 2 * dx;
        int dE = 2 * dy;
        System.out.println(dNE);
        System.out.println(dE);
        int d = 2 * dy - dx;
        int x = x1; int y = y1;
        String position;
        for(int i = 0; i < 10; i++){ // for: number of iterations OR while: x < x2
            System.out.print("(" + x + ", " + y + ")" + " d = " + d);
            if(d <= 0){
                position = "E";
                d += dE;
                System.out.print(", " + position + ", new d = " + d + " (" + x + ", " + y + ")");
                int[] a3 = OriginalZone(x,y,zone);
                System.out.printf(" (%d, %d)", a3[0], a3[1]);
                x++;
            }else{
                position = "NE";
                d += dNE;
                System.out.print(", " + position + ", new d = " + d + " (" + x + ", " + y + ")");
                int[] a3 = OriginalZone(x,y,zone);
                System.out.printf(" (%d, %d)", a3[0], a3[1]);
                x++; y++;
            }
            System.out.println();
        }
    }
    public static int Zone(int x1, int y1, int x2, int y2){
        int dx = x2 - x1;
        int dy = y2 - y1;
        int zone = -1;
        if(Math.abs(dx) > Math.abs(dy)){
            if(dx > 0 && dy > 0){
                zone = 0;
            }else if(dx < 0 && dy > 0){
                zone = 3;
            }else if(dx < 0 && dy < 0){
                zone = 4;
            }else if(dx > 0 && dy < 0){
                zone = 7;
            }
        }else{
            if(dx > 0 && dy > 0){
                zone = 1;
            }else if(dx < 0 && dy > 0){
                zone = 2;
            }else if(dx < 0 && dy < 0){
                zone = 5;
            }else if(dx > 0 && dy < 0){
                zone = 6;
            }
        }
        System.out.println("Zone = " + zone);
        return zone;
    }
}
// Copyright © Asad