import axios from './api.js'
import router from '../router/index.js'

/*
在http.js中将每一个axios请求都给封装为一个函数
parms就是调用该函数的时候需要传递的参数
*/


// 用于访问用户信息
const queryUserInfo = async () => {
	const res = await axios({
		url: `/users/query`,
		method: 'get',

	});
	return res.data;
}
// 用于访问综艺类别信息
const queryStyleInfo = async () => {
	const res = await axios({
		url: `/styles/info`,
		method: 'get',

	});
	return res.data;
}

const query408DataInfo = async ()=>{
	const res = await axios({
		url:'/rates/info',
		method:'get'
	});
	return res.data;
}

// 用于访问综艺详细信息
// const showVariety = async () => {
// 	const res = await axios({
// 		url: `/variety/show`,
// 		method: 'get',

// 	});
// 	return res.data;
// }

const VarietyQuery = async (params) => {
	const res = await axios({
		url: `/variety/${params}/info`,
		method: 'get',

	});
	return res.data;
}

const login = async (params) => {
	const res = await axios({
		headers: {
			"Content-Type": "application/json;charset=UTF-8",
		},
		url: '/users/login',
		method: 'post',
		data: JSON.stringify(params),
	});
	return res.data;
}




export default {
	queryUserInfo,
	queryStyleInfo,
	// showVariety,
	login,
	VarietyQuery,
	query408DataInfo
}