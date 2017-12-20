package servlet;

import java.util.ArrayList;

/**
 * @author: youyinnn
 */
public class MsgChannel {

    private static ArrayList<String> msgChannel = new ArrayList<>();

    private static boolean read = false;

    public static void addMsgLine(String msg){
        read = false;
        msgChannel.add(msg);
    }

    public static void clearMsgChannel(){
        read = false;
        msgChannel.clear();
    }

    public static ArrayList readMsg(){
        if (!read) {
            read = true;
            return msgChannel;
        } else {
            return null;
        }
    }

    public static ArrayList readMsgInRaw(){
        return msgChannel;
    }

    public static boolean getRead() {
        return read;
    }

    public static void main(String[] args) {
        MsgChannel.addMsgLine("hahah");
        System.out.println(MsgChannel.readMsg());
        MsgChannel.addMsgLine("heihei");
        System.out.println(MsgChannel.readMsg());
    }

}
