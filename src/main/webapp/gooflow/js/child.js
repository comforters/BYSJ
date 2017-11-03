var jsondata = {
		   "title": "请假流程",
		   "nodes": {
		    "demo_node_61": {
		            "name": "请假人",
		            "left": 341,
		            "top": 61,
		            "type": "start round",
		            "width": 24,
		            "height": 24,
		            "alt": true
		        },
		        "demo_node_62": {
		            "name": "部门经理审批",
		            "left": 341,
		            "top": 184,
		            "type": "task round",
		            "width": 24,
		            "height": 24,
		            "alt": true
		        },
		        "demo_node_63": {
		            "name": "人事经理审批",
		            "left": 341,
		            "top": 287,
		            "type": "task round",
		            "width": 24,
		            "height": 24,
		            "alt": true
		        },
		        "demo_node_64": {
		            "name": "总经理审批",
		            "left": 342,
		            "top": 408,
		            "type": "end round",
		            "width": 24,
		            "height": 24,
		            "alt": true
		        }
		    },
		    "lines": {
		        "demo_line_65": {
		            "type": "sl",
		            "from": "demo_node_61",
		            "to": "demo_node_62",
		            "name": "",
		            "alt": true
		        },
		        "demo_line_66": {
		            "type": "sl",
		            "from": "demo_node_62",
		            "to": "demo_node_63",
		            "name": "",
		            "alt": true
		        },
		        "demo_line_67": {
		            "type": "sl",
		            "from": "demo_node_63",
		            "to": "demo_node_64",
		            "name": "",
		            "alt": true
		        }
		    },
		   "areas": {},
		   "initNum": 69,
};