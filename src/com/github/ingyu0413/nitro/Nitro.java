package com.github.ingyu0413.nitro;

import java.util.ArrayList;
import java.util.Scanner;

public class Nitro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> users = new ArrayList<>();
        ArrayList<Integer> randomnumber = new ArrayList<>();
        int tries = 0;
        while (true) {
            System.out.println("현재 리스트 내용: " + users);
            System.out.println("그만하려면 'end'를 입력하십시오");
            System.out.print("유저 이름을 입력하십시오: ");
            String username = scanner.nextLine();
            if (username.equals("end")) {
                break;
            } else {
                users.add(username);
            }
        }
        while (true) {
            System.out.println("현재 리스트 내용: " + users);
            System.out.println("수정할 내용이 없다면 'exit'를 입력하십시오");
            System.out.print("수정할 번호를 입력해주세요: ");
            String edituserinput = scanner.next();
            int edituser = 0;
            if (edituserinput.equals("exit")) {
                break;
            }
            try {
                edituser = Integer.parseInt(edituserinput);
            } catch (NumberFormatException e) {
                System.err.println("숫자로 입력해주세요");
                continue;
            }
            edituser -= 1;
            try {
                users.get(edituser);
            } catch (IndexOutOfBoundsException e) {
                System.err.println("범위 내에서 입력해주세요");
                continue;
            }
            System.out.println("현재 해당 내용: " + users.get(edituser));
            System.out.println("수정할려면 'edit', 삭제할려면 'remove'를 입력해주십시오");
            System.out.print("입력해주세요: ");
            String edituserdo = scanner.next();
            if (edituserdo.equals("edit")) {
                System.out.print("바꿀 내용을 입력해주세요: ");
                String editinput = scanner.next();
                users.set(edituser, editinput);
                System.out.println("수정했습니다");
            } else if (edituserdo.equals("remove")) {
                users.remove(edituser);
                System.out.println("삭제했습니다.");
            }
        }
        for (int i = 0; i < users.size(); i++) {
            randomnumber.add(0);
        }
        while (true) {
            System.out.println("현재 리스트 내용: " + users);
            System.out.print("추첨 횟수를 지정해주세요: ");
            try {
                tries = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.err.println("숫자로 입력해주세요");
                continue;
            }
            for (int i = 0; i < tries; i++) {
                int tmp1 = (int) (Math.random()*users.size());
                int tmp2 = randomnumber.get(tmp1);
                randomnumber.set(tmp1, tmp2+1);
                System.out.println((i+1) + ": " + users.get(tmp1));
            }
            if (tries == 1) {
                System.out.println(users.get(randomnumber.indexOf(1)) + "님 당첨!");
            } else {
                for (int i = 0; i < users.size(); i++) {
                    double percent = ((double) randomnumber.get(i))/tries;
                    System.out.println(users.get(i) + ", " + randomnumber.get(i) + " (" + percent*100 + "%)");
                }
            }
            System.out.println("그만하려면 'exit'를 입력하십시오");
            System.out.print("아무키나 눌러 계속 추첨하세요: ");
            String boolcontinue = scanner.next();
            if (boolcontinue.equals("exit")) {
                break;
            }
        }
        System.out.println("프로그램 종료");
    }
}
