tip:
  1、第一个版本使用list操作，虽然能够实现，但是超时
  2、第二个版本使用StringBuilder，符合条件
  
  总结：能用集合解决的问题，不要用list
  
String知识点：
  1、s.length()
  2、s.charAt(i),获取i位置的代码单元
  
StringBuilder知识点：
  1、sb.indexOf(str),>=0，代表存在，<0代表不存在
  2、sb.delete(0, sb.indexOf(str) + 1);，删除，start>=0，当start=end时不变，必须满足end>=start
