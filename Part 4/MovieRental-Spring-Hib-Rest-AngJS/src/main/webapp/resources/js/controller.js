function ContactController($scope){
	$scope.contacts=[{id:0, name:'naresh', email:'naresh@gmail.com', phone:1298129891, desc:'xyz'},
	                 {id:1, name:'mahesh', email:'mahesh@gmail.com', phone:0938409382, desc:'sdf'},
	                 {id:2, name:'suresh', email:'suresh@gmail.com', phone:9349782492, desc:'cxv'},
	                 {id:3, name:'kranti', email:'kranti@gmail.com', phone:9032483499, desc:'req'},
	                 {id:4, name:'pavan', email:'pavan@gmail.com', phone:0932402392, desc:'fdg'}];
	$scope.message = '';
	$scope.btnValue = 'Add';
	$scope.newcontact = {};
	$scope.selectedContact = {};
	$scope.sortField = undefined;
	$scope.reverse = false;
	
	$scope.add = function(id){
		$scope.btnValue = 'Add';
		if(id == null){
			$scope.newcontact.id = uid++;
			$scope.contacts.push($scope.newcontact);
		} else {
			for(i in $scope.contacts){
				if($scope.contacts[i].id == id){
					$scope.contacts[i] = angular.copy($scope.newcontact);
				}
			}					
		}
		$scope.newcontact = {};
	}
	
	$scope.delete = function(id){
		for(i in $scope.contacts){
			if($scope.contacts[i].id == id){
				$scope.contacts.splice(i);
			}
		}
	}
	
	$scope.edit = function(id){
		$scope.btnValue = 'Update';
		for(i in $scope.contacts){
			if($scope.contacts[i].id == id){
				$scope.newcontact = angular.copy($scope.contacts[i]);
			}
		}
	}
	
	$scope.selectContact = function(contact){
		$scope.selectedContact = contact;
	}
	
	$scope.isSelected = function(contact){
		return $scope.selectedContact === contact;
	}
	
	$scope.sort = function(sortField){
		if($scope.sortField == sortField){
			$scope.reverse = !$scope.reverse;
		} else {
			$scope.sortField = sortField;
			$scope.reverse = false;
		}
	}
	
	$scope.isSortUp = function (fieldName) {
		return $scope.sortField === fieldName && !$scope.reverse;
	};
	
	$scope.isSortDown = function (fieldName) {
		return $scope.sortField === fieldName && $scope.reverse;
	};
}


