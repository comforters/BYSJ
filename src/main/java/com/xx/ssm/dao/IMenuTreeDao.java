package com.xx.ssm.dao;

import java.util.List;

import com.xx.ssm.entity.TreeNode;

public interface IMenuTreeDao {
	 public List<TreeNode> queryTreeNodes(int topId);
}
