package entity;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.List;
import java.util.Properties;


public class Work {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.load(ClassLoader.getSystemResourceAsStream("jdbc.properties"));
        ProcessEngineConfiguration process = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        process.setJdbcDriver(prop.getProperty("driver"));
        process.setJdbcUrl(prop.getProperty("url"));
        process.setJdbcUsername(prop.getProperty("username"));
        process.setJdbcPassword(prop.getProperty("password"));
        process.setDatabaseSchemaUpdate("true");
        ProcessEngine processEngine = process.buildProcessEngine();
//        startJob();
        search(processEngine, "人事");
        doJob(processEngine, "87502");
//        search(processEngine);
    }

    /**
     * 流程部署，启动
     */
    public static void startJob() {
        //  部署流程定义
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        Deployment deployment = defaultProcessEngine.getRepositoryService().createDeployment().name("请假流")
                .addClasspathResource("work.bpmn")
                .addClasspathResource("work.png")
                .addClasspathResource("work.xml")
                .deploy();
        System.out.println("1       " + deployment.getId());
        System.out.println("2       " + deployment.getName());
        System.out.println("3       " + deployment.getDeploymentTime());
        System.out.println("4       " + deployment.getKey());
        // 启动流程实例
        String key = "work";
        ProcessInstance processInstance = defaultProcessEngine.getRuntimeService().startProcessInstanceByKey(key);
        System.out.println("5       " + processInstance.getId());
        System.out.println("6       " + processInstance.getProcessDefinitionId());
    }

    /**
     * 完成我的任务
     *
     * @param processEngine
     * @param taskId        任务ID
     */
    public static void doJob(ProcessEngine processEngine, String taskId) {
        //String taskId= "72512";
        try {
            processEngine.getTaskService()//与正在执行的任务管理相关的Service
                    .complete(taskId);
            System.out.println("完成任务：任务ID:" + taskId);
        } catch (Exception e) {
            System.out.println("没有相关的任务");
        }
    }

    /**
     * 查询流程
     *
     * @param processEngine
     * @param assignee      节点名字
     */

    public static void search(ProcessEngine processEngine, String assignee) {
        //= "张三";
        List<Task> list = processEngine.getTaskService()//与正在执行的任务管理相关的Service
                .createTaskQuery()//创建任务查询
                .taskAssignee(assignee)//指定个人任查询，指定办理人
                .list();
        if (list != null && list.size() > 0) {
            for (Task task : list) {
                System.out.println("任务ID:" + task.getId());
                System.out.println("任务名称:" + task.getName());
                System.out.println("任务的创建时间:" + task.getCreateTime());
                System.out.println("任务的办理人:" + task.getAssignee());
                System.out.println("流程实例ID:" + task.getProcessInstanceId());
                System.out.println("执行对象ID:" + task.getExecutionId());
                System.out.println("流程定义ID:" + task.getProcessDefinitionId());
                System.out.println("############################################");
            }
        } else {
            System.out.println("没有对应的任务了");
        }
    }

}
