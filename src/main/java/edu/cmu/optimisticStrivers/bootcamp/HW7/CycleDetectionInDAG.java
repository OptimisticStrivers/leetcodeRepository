package edu.cmu.optimisticStrivers.bootcamp.HW7;

/**
 * @ClassName: CycleDetectionInDAG
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/31 12:17 PM
 * @Version 1.0
 */
public class CycleDetectionInDAG {
//    https://www.jianshu.com/p/8c11c711b18b
//    https://blog.csdn.net/qq_38168462/article/details/121029773
    //拓扑排序
    //每次从有向图中取出一个入度为 0 的节点删除，同时删除该节点及所有以他为起点的边，若最终图为空则证明无环，最终非空则证明有环。


//    def cycleDectect(vertex_dict):
//    vertex_num = len(vertex_dict)
//  for i in range(0,vertex_num): #一共拓扑删除入度为0的节点
//    #find a in_degree == 0
//    target_vertex = None
//    for key in vertex_dict:
//    cur_vertex = vertex_dict[key]
//            if len(cur_vertex.from_vertexes) == 0:
//    target_vertex = cur_vertex
//        for vertex in target_vertex.to_vertexes:
//            vertex.from_vertexes.remove(target_vertex)
//            break
//            if target_vertex is None:
//            return True #has cycle
//    vertex_dict.pop(target_vertex.value)
//            return False
//
//
//
//    class vertex(object):
//    def __init__(self,value):
//    self.value = value
//    self.to_vertexes = []
//    self.from_vertexes = []
}
