package colourThread;





public class SynchronizedMain {


        public static void main(String[] args) {

        SynchronizedRGB black = new SynchronizedRGB(0,0,0,"black");
        SynchronizedRGB white = new SynchronizedRGB(255,255,255,"white");


        new Thread(new Runnable() {
            public void run() {
                System.out.println(black.getName());
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    new Thread(new Runnable() {
                        public void run() {


                            System.out.println(black.getName());
                            System.out.println(black.getRGB());
                        }
                    }).join(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(black.getRGB());
            }
        }).start();




           /* new Thread(black).start();
            new Thread(white).start();
*/


//            System.out.format("colorBlackRGB: %s%n" ,  colorBlack.getRGB());
//            System.out.format("colorWhiteRGB: %s%n" ,  colorWhite.getRGB());

        }
    }

