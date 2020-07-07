import React from 'react';
import AllAirmanData from './AllAirmanData';


import {
    Route,
    Link
} from 'react-router-dom'

function AllAirmanDataList({AllAirmanData, parent})
{
    return (
        <div>
            <Route exact path = "/all-airman-data"><div>
            <div className="center">
    {AllAirmanData.map(data => {console.log(data);return <AllAirmanData id = {data.amn_id} rank = {data.rank} first_name = {data.first_name} last_name = {data.last_name}/> })}
                </div></div></Route>

        </div>
    )
}
export default AllAirmanDataList