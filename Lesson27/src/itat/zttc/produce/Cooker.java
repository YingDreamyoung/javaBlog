package itat.zttc.produce;

import java.util.Random;

public class Cooker implements Runnable{
	private String name;//����������
	private String[] foods;//��������Ʒ
	private Disk d;//�ֿ�
	private static Random ran = new Random(47);
	
	/*public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getFoods() {
		return foods;
	}
	public void setFoods(String[] foods) {
		this.foods = foods;
	}
	public Disk getD() {
		return d;
	}
	public void setD(Disk d) {
		this.d = d;
	}*/
	//���캯��
	public Cooker(String name, Disk d) {
		this.name = name;
		this.d = d;
		foods = new String[]{"����","��ͷ","����","ϡ��","��֭",
					"�ȷ�","��˪","����","����","���","��ҩ","��ҩ","�ΰ�"};
	}
	//������Ʒ
	
	public void make() {
		//����ͬ��
		synchronized (d) {
			//���dΪ�ս�������
			if(d.isEmpty()) {
				//���������Ʒ
				int index = ran.nextInt(foods.length);
				String f = foods[index];
				System.out.println(name+"������"+f);
				//���������Ʒ
				d.setFood(f);
				//���ô��ⲻΪ��
				d.setEmpty(false);
				//����һ��������ȣ���ȥ����������
				d.notify();
				try {
					//����˯��,��Ҫ��ߵ�����ִ����ɲ�ִ������������
					System.out.println("2000");
					Thread.sleep(2000);
					d.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				//������еȴ���
				try {
					d.wait();//��Ҫ������߳̽��л���
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	@Override
	public void run() {
		//����20��������
		for(int i=0;i<20;i++) {
			make();
		}
	}
}