public class demo4 {
    public static void main(String[] args) throws Exception {
        int time = 0;
        for (int i = 0; i < 10; i++) {
            Thread.sleep(2 * 1000);
            System.out.println("############ 第" + i + "次查询还款记录");
            if (i == 12) {

                System.out.println("############ 第" + i + "次查询结果：交易成功");
                break;
            } else if (i == 11) {
                System.out.println("########### 第" + i + "次查询结果：交易失败");
                break;
            } else {
                time++;
                continue;
            }
        }
        if (time == 10) {
            System.out.println(time);
            System.out.println("请联系快钱技术人员进行线下处理！");
        }
    }
}

