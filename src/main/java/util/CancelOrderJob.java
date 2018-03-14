package util;

/**
 * @Author YZ
 * @Date 2018/3/14
 */

import org.hibernate.dialect.pagination.TopLimitHandler;
import service.OrderService;
import service.impl.OrderServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 取消过了15分钟未支付的订单，并触发器实现订单取消以及学生班级的取消
 * quartz任务的job,用于检测数据库失效订单并将其关闭
 * @DisallowConcurrentExecution 这个注解标明上个任务没有执行完毕不会执行下个任务
 */

public class CancelOrderJob {
    public static final long EFFTIVE_TIME=15*60*1000;

    OrderService orderService=new OrderServiceImpl();
    List<ToPayOrderVO> list=orderService.getAllToPay();
    public void execute() throws ParseException {
        Queue<ToPayOrderVO> queue=new LinkedList<ToPayOrderVO>();
        if(!list.isEmpty()){
            for(ToPayOrderVO vo:list){
                queue.offer(vo);
            }
        }
        ToPayOrderVO pvo=queue.peek();
        while(pvo!=null){
            Long diff=checkOrder(pvo);
            if(diff!=null&&diff>=EFFTIVE_TIME){
                queue.poll();
                pvo=queue.peek();
            }else if(diff<EFFTIVE_TIME){
                try {
                    Thread.sleep(EFFTIVE_TIME-diff);
                } catch (InterruptedException e) {
                    System.out.println("CancelOrderJob.checkOrder定时任务出现问题");
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * 获取某个订单下单时间和现在的时间差
     * @param vo
     * @return
     * @throws ParseException
     */
    public Long checkOrder(ToPayOrderVO vo) throws ParseException {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long diff=null;
        if(vo!=null){
            Date createTime=vo.getOrder_time();
            diff=sdf.parse(sdf.format(date)).getTime()-createTime.getTime();
        }
        return diff;
    }

}
