package LittleHomework;

public enum H001Enum {
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;

    public static void main(String[] args) {
        H001Enum[] arr=H001Enum.values();
        for (H001Enum i:arr) {
            System.out.println(i.toString());
        }
    }
}
